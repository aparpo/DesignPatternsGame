package strategyPattern;
import java.util.ArrayList;
import java.util.List;
import base.ActionType;
import base.Character;
import base.Enemy;
import decoratorPattern.ActiveItemDecorator;

public class MediumStrategy implements StrategyTemplate{

	public void attack(Enemy user, Character player ) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>();
		list = user.getEquipment().areThereAnyActives(list);
		list.get(objectType(ActionType.OFFENSIVE, user)).useSkill(user, player);
	}
	public void defense(Enemy user, Character player) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>();
		list = user.getEquipment().areThereAnyActives(list);
		list = user.getEquipment().areThereAnyActives(list);
		list.get(objectType(ActionType.DEFENSIVE, user)).useSkill(user, player);
	}
	public void neutral(Character user, Character player) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>();
		list = user.getEquipment().areThereAnyActives(list);
		list = user.getEquipment().areThereAnyActives(list);
		list.get(objectType(ActionType.NEUTRAL, user)).useSkill(user, player);
	}
	
	public int worthDefense(Character user, Character player) {
		
		if( objectType(ActionType.DEFENSIVE, user) == -1) {
			return 0;
		}else {
			int i = 0;
			if(player.getEquipment().getAttack() > user.getEquipment().getDefense()*1.3) {
				i++;
			}
			if(user.getEquipment().getLife() < 0.75* user.getEquipment().getLife()) {
				i++;
			}
			return i;
		}
		
	}
	public int worthAttack(Character user, Character player) {
		if( objectType(ActionType.OFFENSIVE, user) == -1) {
			return 0;
		}else { 
			int i = 0;
			if(user.getEquipment().getAttack() > player.getEquipment().getDefense()) {
				i++;
			}
			if(user.getEquipment().getAttack()*3 > player.getEquipment().getLife()) {
				i++;
			}
			return i;
		}
	}
	public int possibleNeutral(Character user) {
		if(objectType(ActionType.NEUTRAL, user) != -1) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public boolean oneShotWithooutPassiveItems(Character user, Character player) {
		return user.getEquipment().getAttack()-player.getEquipment().getDefense() < 0;
	}
	
	public int objectType(ActionType style, Character user) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = user.getEquipment().areThereAnyActives(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getActionType() == style) {
				return -1;
			}
		}
		return -1;
	}
	
}

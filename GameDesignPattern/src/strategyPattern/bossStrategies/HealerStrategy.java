package strategyPattern.bossStrategies;

import java.util.ArrayList;
import java.util.List;
import base.ActionType;
import base.Character;
import base.Enemy;
import base.Player;
import decoratorPattern.ActiveItemDecorator;
import singletonPattern.GameManager;
import statePattern.StateStandard;
import strategyPattern.DecisionTemplate;

public class HealerStrategy extends DecisionTemplate{
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		int heal = objectType(ActionType.NEUTRAL, user);
		int canHeal = canHealPosition(skills);
		if(heal !=-1) {
			if(canHeal!=-1) {
				heal(user, target, skills, canHeal);
			}else {
				defense(user, target, skills);
			}
		}else {
			defense(user, target, skills);
		}
	}
	private void heal(Enemy user, Character player, List<ActiveItemDecorator> skills, int pos) {
		int target = -1;
		if(skills.get(pos).getName().equalsIgnoreCase("Potion")) {
			boolean firtEnemy = false;
			for(int i =0; i < GameManager.getManager().getCharacters().size(); i++) {
				if(GameManager.getManager().getCharacters().get(i) instanceof Enemy) {
					if(firtEnemy) {
						target = i;
					}else if(GameManager.getManager().getCharacters().get(i).getEquipment().getLife() < GameManager.getManager().getCharacters().get(target).getEquipment().getLife()) {
						target = i;
					}
				}
			}
		}else {
			for(int i =0; i < GameManager.getManager().getCharacters().size(); i++) {
				if(GameManager.getManager().getCharacters().get(i) instanceof Enemy) {
					if(!(GameManager.getManager().getCharacters().get(i).getState().getState() instanceof StateStandard)) {
						target = i;
					}
				}
			}
		}
		if(target == 0) {
			skills.get(pos).useSkill(user, user);
		}else {
			skills.get(pos).useSkill(user, GameManager.getManager().getCharacters().get(target));
		}
		
	}
	private void defense(Enemy user, Character player, List<ActiveItemDecorator> skills) {
		skills.get(objectType(ActionType.DEFENSIVE, user)).useSkill(user, player);
	}
	
	private int canHealPosition(List<ActiveItemDecorator>skills) {
		for(int i =0; i < skills.size(); i++) {
			if(skills.get(i).getName().equalsIgnoreCase("Potion") ||skills.get(i).getName().equalsIgnoreCase("Antidote")) {
				return i;
			}
		}
		return -1;
	}
	public int objectType(ActionType style, Character user) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = user.getEquipment().areThereAnyActives(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getActionType() == style) {
				return i;
			}
		}
		return -1;
	}
	
	protected int worthAttack(Enemy user, Player player) {
		return 0;
	}
	protected int worthDefend(Enemy user, Player player) {
		return 0;
	}
	protected int worthNeutral(Enemy user, Player player) {
		return 0;
	}
}

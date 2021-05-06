package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import base.ActionType;
import base.Character;
import base.Enemy;
import base.Player;
import decoratorPattern.ActiveItemDecorator;

public class HardStrategy extends DecisionTemplate implements StrategyTemplate{


	public int worthAttack(Character enemy, Character player) {
		int probability = -1;
		int damageActiveItem = 0;
		int tierList = 0;
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = enemy.getEquipment().areThereAnyActives(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getActionType() == ActionType.OFFENSIVE) {
				probability = 0;
				if(damageActiveItem < list.get(i).getAttack()) {
					damageActiveItem = list.get(i).getAttack();
				}
				if(list.get(i).getName().equalsIgnoreCase("DeathSpear")) {
					probability = 100;
					return probability;
				}
			}
		}
		
		if(probability == -1) {
			return 0;
		}else {
			int i = 0;
			if(enemy.getEquipment().getAttack()+damageActiveItem > player.getEquipment().getDefense()) {
				i++;
			}
			if(enemy.getEquipment().getLife()*3 > player.getEquipment().getLife()) {
				i++;
			}
			// if con el tier del arma
			return i;
		}
	}
	public int worthDefense(Character enemy, Character player) {
		return 0;
	}
	public void attack(Enemy user, Character player) {
		
	}
	public void defense(Enemy user, Character player) {
		
	}
	public void neutral(Character user, Character player) {
		
	}
	protected int worthAttack() {
		return 0;
	}
	protected int worthDeffend() {

		return 0;
	}
	protected int worthNeutral() {
		return 0;
	}
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		
		
	}
	
	public int objectType(ActionType style, Character user) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = user.getEquipment().areThereAnyActives(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getActionType() == style) {
				return 0;
			}
		}
		return -1;
	}
}

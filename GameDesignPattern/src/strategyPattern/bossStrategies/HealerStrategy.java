package strategyPattern.bossStrategies;

import java.util.ArrayList;
import java.util.List;
import base.ActionType;
import base.Character;
import base.Enemy;
import base.Player;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.items.*;
import singletonPattern.GameManager;
import statePattern.StateStandard;
import strategyPattern.DecisionTemplate;
// Sobreescribir analize
// variables globales, borrar canHeal
public class HealerStrategy extends DecisionTemplate{
	ActiveItemDecorator offensive;
	ActiveItemDecorator defensive;
	ActiveItemDecorator neutral;
	ActiveItemDecorator heal;
	int targetPos = 0;
	protected int[] analize(Enemy user, Player player) {
		int[] options = new int[4];
		options[0] = worthAttack(user,  player);
		options[1] = worthDefend(user,  player);
		options[2] = worthNeutral(user,  player);
		options[3] = worthHeal(user, player);
		return options;
	}
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		int total = 0;
		for(int i =0; i < options.length; i++) {
			total += options[i];
		}
		int random = (int)Math.random()*(total+1);
		if(random < options[0]) {
			offensive.useSkill(user, target);
		}else if(random < options[0] + options[1]) {
			defensive.useSkill(user, target);
		}else if(random < options[0] + options[1] + options[2]){
			neutral.useSkill(user, target);
		}else {
			heal.useSkill(user, GameManager.getManager().getCharacters().get(targetPos));
		}
	}
	private int worthHeal(Enemy user, Character player) {
		List<ActiveItemDecorator> skills = new ArrayList<ActiveItemDecorator>();
		skills = user.getEquipment().areThereAnyActives(skills);
		heal = (ActiveItemDecorator) user.getEquipment().isThereAny(new Potion(0));
		if(heal == null) {
			heal = (ActiveItemDecorator) user.getEquipment().isThereAny(new Antidote(0));
			if(heal == null) {
				return 0;
			}else {
				for(int i =0; i < GameManager.getManager().getCharacters().size(); i++) {
					if(GameManager.getManager().getCharacters().get(i) instanceof Enemy) {
						if(!(GameManager.getManager().getCharacters().get(i).getState().getState() instanceof StateStandard)) {
							targetPos = i;
						}
					}
				}
			}
		}else {
			boolean firtEnemy = false;
			for(int i =0; i < GameManager.getManager().getCharacters().size(); i++) {
				if(GameManager.getManager().getCharacters().get(i) instanceof Enemy) {
					if(firtEnemy) {
						targetPos = i;
					}else if(GameManager.getManager().getCharacters().get(i).getEquipment().getLife() < GameManager.getManager().getCharacters().get(targetPos).getEquipment().getLife()) {
						targetPos = i;
					}
				}
			}
		}
		if(targetPos == -1) {
			return 0;
		}else {
			return 10;
		}
		
	}
	
	private ActiveItemDecorator selectItem(ActionType style, Character user) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = user.getEquipment().areThereAnyActives(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getActionType() == style) {
				return list.get(i);
			}
		}
		return null;
	}
	
	protected int worthAttack(Enemy user, Player player) {
		offensive = selectItem(ActionType.OFFENSIVE, user);
		return 1;
	}
	protected int worthDefend(Enemy user, Player player) {
		defensive = selectItem(ActionType.DEFENSIVE, user);
		return 1;
	}
	protected int worthNeutral(Enemy user, Player player) {
		neutral = selectItem(ActionType.NEUTRAL, user);
		if(neutral == null) {
			return 0;
		}else {
			return 1;
		}
	}
}

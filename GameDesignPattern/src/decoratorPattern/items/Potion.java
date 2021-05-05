package decoratorPattern.items;

import base.Action;
import base.ActionType;
import base.Character;
import base.SkillType;
import base.Stats;
import decoratorPattern.Equipment;
import decoratorPattern.UsableItemDecorator;
import singletonPattern.GameManager;

public class Potion extends UsableItemDecorator{ //Cura 50 de vida 
	
	public Potion(Equipment equipment, int amount) {
		super(equipment, "Potion", "Use potion", 0, 0, 0, 0, 0,ActionType.NEUTRAL, SkillType.MAGIC, amount);
	}

	@Override
	public void useSkill(Character user, Character target) {
		if(amount > 0) { //Quedan pociones
			int heal;
			//Asegurar que no se cura por encima de su vida maxima
			if(user.getEquipment().getLife()<= user.getEquipment().getMaxLife()-50) {
				heal = 50;
			}else {
				heal = user.getEquipment().getMaxLife() - user.getEquipment().getLife();
			}
			Stats variation = new Stats(heal, 0, 0, 0, 0);
			GameManager.getManager().getActions().add(new Action(variation, actionType, skillType, user, user));
			amount--;	
		}
		
	}
}

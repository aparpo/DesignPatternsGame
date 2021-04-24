package decoratorPattern.items;

import base.Character;
import decoratorPattern.Action;
import decoratorPattern.ActionType;
import decoratorPattern.Item;
import decoratorPattern.SkillType;
import decoratorPattern.Stats;
import decoratorPattern.UsableItemDecorator;
import singletonPattern.GameManager;

public class Potion extends UsableItemDecorator{
	
	public Potion(Item equipment, int amount) {
		super(equipment, "Potion", "Use potion", 0, 0, 0, 0, 0, amount);
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
			GameManager.getManager().getActions().add(new Action(variation, ActionType.NEUTRAL, SkillType.MAGIC, user));
			amount--;	
		}
		
	}
}

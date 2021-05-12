package decoratorPattern.items;

import base.*;
import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class Potion extends UsableItemDecorator{ //Cura 50 de vida 
	
	public Potion() {
		super();
	}
	public Potion(Item equipment, int amount) {
		super(equipment, "Potion", "Use potion", 0, 0, 0, 0, 0,ActionType.NEUTRAL, SkillType.MAGIC,Tier.C, amount);
	}
	public Potion(int amount) {
		this(null, amount);
	}
	
	@Override
	public void useSkill(Character user, Character target) {
		if(amount > 0) { //Quedan pociones
			int heal;
			//Asegurar que no se cura por encima de su vida maxima
			if(target.getEquipment().getLife()<= target.getEquipment().getMaxLife()-50) {
				heal = 50;
			}else {
				heal = target.getEquipment().getMaxLife() - target.getEquipment().getLife();
			}
			Stats variation = new Stats(heal, 0, 0, 0, 0);
			GameManager.getManager().getActions().add(new Action(variation, actionType, skillType, user, target));
			amount--;	
		}
		
	}
}

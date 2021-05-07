package decoratorPattern.items;

import base.*;
import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;


public class FireStaff extends ActiveItemDecorator{ //Ataque basico magico, ignora la defensa

	public FireStaff(Item equipment) {
		super(equipment, "Fire Staff", "Fire ball", 0, 0, 10, 0, 0,ActionType.OFFENSIVE, SkillType.MAGIC, Tier.B);
	}

	@Override
	public void useSkill(Character user, Character target) {
		Stats variation = new Stats(-10, 0, 0, 0, 0); //Actualizar vida actual
		
		GameManager.getManager().getActions().add(new Action(variation, actionType, skillType,user, target));
	}

}

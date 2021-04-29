package decoratorPattern.items;

import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;


public class FireStaff extends ActiveItemDecorator{ //Ataque basico magico, ignora la defensa

	public FireStaff(Equipment equipment) {
		super(equipment, "Fire Staff", "Fire ball", 0, 0, 10, 0, 0,ActionType.OFFENSIVE, SkillType.MAGIC);
	}

	@Override
	public void useSkill(Character user, Character target) {
		Stats variation = new Stats(-10, 0, 0, 0, 0); //Actualizar vida actual
		
		GameManager.getManager().getActions().add(new Action(variation, actionType, skillType,user, target));
	}

}

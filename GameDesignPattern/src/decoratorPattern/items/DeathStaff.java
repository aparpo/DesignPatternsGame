package decoratorPattern.items;

import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class DeathStaff extends ActiveItemDecorator{ //Mata al enemigo a cambio de ponerte un estado negativo

	public DeathStaff(Item equipment) {
		super(equipment, "Death Staff", "Kill", 0, 0, 10, 0, 0,ActionType.OFFENSIVE, SkillType.MAGIC);
	}

	@Override
	public void useSkill(Character user, Character target) {
		Stats variation = new Stats(-target.getEquipment().getLife(), 0, 0, 0, 0); //Actualizar vida actual a cero
		//Cambiar estado a estado negativo
		GameManager.getManager().getActions().add(new Action(variation, actionType, skillType,user, target));
	}

}

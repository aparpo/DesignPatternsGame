package decoratorPattern.items;

import base.*;
import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class DeathStaff extends ActiveItemDecorator{ //Mata al enemigo a cambio de ponerte un estado negativo

	public DeathStaff() {
		super();
	}
	public DeathStaff(Item equipment) {
		super(equipment, "Death Staff", "Kill", 0, 0, 10, 0, 0,ActionType.OFFENSIVE, SkillType.MAGIC, Tier.S);
	}

	@Override
	public void useSkill(Character user, Character target) {
		Stats variation = new Stats(-target.getEquipment().getLife(), 0, 0, 0, 0); //Actualizar vida actual a cero
		GameManager.getManager().getActions().add(new Action(variation, actionType, skillType,user, target));
	}

}

package decoratorPattern.items;

import base.*;
import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class Staff extends ActiveItemDecorator{ //Ataque basico con espada

	public Staff() {
		super();
	}
	public Staff(Item equipment) {
		super(equipment, "Staff", "Staff Magic", 0, 0, 10, 0, 0, ActionType.OFFENSIVE, SkillType.MAGIC, Tier.C);
	}

	@Override
	public void useSkill(Character user, Character target) {
		int aux = user.getEquipment().getAttack()- target.getEquipment().getDefense(); //Resultado del combate
		if(aux <= 0) { //La defensa es mayor que el ataque
			aux = 0; //La vida que se resta al objetivo es cero
		}
		Stats variation = new Stats( -aux, 0, 0, 0, 0); //Actualizar vida actual
		
		GameManager.getManager().getActions().add(new Action(variation, actionType, skillType,user, target));
	}

}

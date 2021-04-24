package decoratorPattern.items;

import base.Character;
import decoratorPattern.Action;
import decoratorPattern.ActionType;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Item;
import decoratorPattern.SkillType;
import decoratorPattern.Stats;
import singletonPattern.GameManager;

public class LongSword extends ActiveItemDecorator{ //Ataque basico con espada

	public LongSword(Item equipment) {
		super(equipment, "Long Sword", "Sword Attack", 0, 0, 10, 0, 0);
	}

	@Override
	public void useSkill(Character user, Character target) {
		int aux = user.getEquipment().getAttack()- target.getEquipment().getDefense(); //Resultado del combate
		if(aux <= 0) { //La defensa es mayor que el ataque
			aux = 0; //La vida que se resta al objetivo es cero
		}
		Stats variation = new Stats(target.getEquipment().getLife() - aux, 0, 0, 0, 0); //Actualizar vida actual
		
		GameManager.getManager().getActions().add(new Action(variation, ActionType.OFFENSIVE, SkillType.PHYSICAL,user, target));
	}

}

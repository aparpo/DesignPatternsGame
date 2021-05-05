package decoratorPattern.items;

import base.Action;
import base.ActionType;
import base.Character;
import base.SkillType;
import base.Stats;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class Bow extends ActiveItemDecorator{ //El ataque con arco hace mas daño pero puede fallar

	public Bow(Equipment equipment) {
		super(equipment, "Bow", "Shoot Arrow", 0, 0, 5, 0, 0, ActionType.OFFENSIVE, SkillType.PHYSICAL);
	}

	@Override
	public void useSkill(Character user, Character target) {
		int aux;
		if(Math.random() >0.3) { //Puede fallar
			aux = user.getEquipment().getAttack()- target.getEquipment().getDefense()/2; //Ignora parte de la defensa
			if(aux <= 0) { //La defensa es mayor que el ataque
				aux = 0; //La vida que se resta al objetivo es cero
			}
		}else {
			aux = 0;
		}
		
		Stats variation = new Stats(-aux, 0, 0, 0, 0); //Actualizar vida actual
		
		GameManager.getManager().getActions().add(new Action(variation, actionType, skillType,user, target));
	}

}

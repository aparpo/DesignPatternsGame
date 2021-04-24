package decoratorPattern.items;

import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class Bow extends ActiveItemDecorator{ //El ataque con arco hace mas da�o pero puede fallar

	public Bow(Item equipment) {
		super(equipment, "Bow", "Shoot Arrow", 0, 0, 5, 0, 0);
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
		
		Stats variation = new Stats(target.getEquipment().getLife() - aux, 0, 0, 0, 0); //Actualizar vida actual
		
		GameManager.getManager().getActions().add(new Action(variation, ActionType.OFFENSIVE, SkillType.PHYSICAL,user, target));
	}

}

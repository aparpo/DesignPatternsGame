package decoratorPattern.items.bossWeapons;

import base.Action;
import base.ActionType;
import base.Character;
import base.SkillType;
import base.Stats;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Item;
import decoratorPattern.Tier;
import singletonPattern.GameManager;

public class QuelaagWeapon extends ActiveItemDecorator{ //Resta un porcentaje de vida al usuario que utiliza la habilidad

	public QuelaagWeapon() {
		this(null);
	}
	public QuelaagWeapon(Item equipment) {
		super(equipment, "Chaos Blade", "Black Fire Slash", new Stats(0, 0, 35, 0, 0), ActionType.OFFENSIVE, SkillType.PHYSICAL, Tier.A);
	}

	public void useSkill(Character user, Character target) {
		int aux = user.getEquipment().getAttack() - (target.getEquipment().getDefense() / 2); //Resultado del combate, ignorando la mitad de la defensa del objetivo.
		if(aux <= 0) { //La defensa es mayor que el ataque.
			aux = 0; //La vida que se resta al objetivo es cero.
		}		
		Stats variationTarget = new Stats( -aux, 0, 0, 0, 0); //Actualizar vida actual del objetivo.
		
		Stats variationUser;
		if(target.getEquipment().getLife() > 1 && target.getEquipment().getLife() < (aux / 4)) {
			variationUser = new Stats( -(target.getEquipment().getLife() - 1) , 0, 0, 0, 0); //Si el da�o es superior a la vida del usuario y este tiene m�s de 1 de vida, 
																							//en vez de matarle le deja a 1 de vida.
		}
		
		else {
			variationUser = new Stats( -(aux / 4) , 0, 0, 0, 0); //Actualizar vida actual del usuario.
		}
		
		GameManager.getManager().getActions().add(new Action(variationTarget, actionType, skillType, user, target));
		GameManager.getManager().getActions().add(new Action(variationUser, actionType, skillType, user, user));
		inform(user,target);

	}

}

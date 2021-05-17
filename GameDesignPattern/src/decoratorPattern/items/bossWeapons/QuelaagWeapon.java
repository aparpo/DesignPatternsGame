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
import statePattern.States;

public class QuelaagWeapon extends ActiveItemDecorator{ //Resta un porcentaje de vida al usuario que utiliza la habilidad

	public QuelaagWeapon() {
		this(null);
	}
	public QuelaagWeapon(Item equipment) {
		super(equipment, "Chaos Blade", "Black Fire Slash", new Stats(0, 0, 35, 0, 0), ActionType.OFFENSIVE, SkillType.PHYSICAL, Tier.A);
	}

	@Override
	public void useSkill(Character user, Character target) {
		int aux = user.getEquipment().getAttack()- target.getEquipment().getDefense(); //Resultado del combate
		if(aux <= 0) { //La defensa es mayor que el ataque
			aux = 0; //La vida que se resta al objetivo es cero
		}
		
		Stats variationTarget = new Stats( -aux, 0, 0, 0, 0); //Actualizar vida actual del objetivo
		Stats variationUser = new Stats( -(aux / 4) , 0, 0, 0, 0); //Actualizar vida actual del objetivo
		
		GameManager.getManager().getActions().add(new Action(variationTarget, actionType, skillType, user, target));
		inform(user,target);
		GameManager.getManager().getActions().add(new Action(variationUser, actionType, skillType, user, user));
		inform(user, user);
	}

}

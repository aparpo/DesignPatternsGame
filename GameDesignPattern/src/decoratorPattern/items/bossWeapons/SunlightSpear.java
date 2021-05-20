package decoratorPattern.items.bossWeapons;

import java.util.Random;
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

public class SunlightSpear extends ActiveItemDecorator{ //Puede inflingir un golpe cr�tico y paraliza al objetivo.

	public SunlightSpear() {
		this(null);
	}
	public SunlightSpear(Item equipment) {
		super(equipment, "Sunlight Spear", "Thunder Spike", new Stats(0, 0, 50, 0, 0), ActionType.OFFENSIVE, SkillType.PHYSICAL, Tier.S);
	}

	public void useSkill(Character user, Character target) {
		Random rand = new Random();
		
		int aux = user.getEquipment().getAttack() - (target.getEquipment().getDefense() / 3); //Resultado del combate, ignorando dos tercios de la defensa del objetivo.
		
		if(rand.nextInt() < 30) { //Tiene una probabilidad del 30% de hacer golpe cr�tico.
			aux = (int) (aux * 1.5);
		}
		
		if(aux <= 0) { //La defensa es mayor que el ataque.
			aux = 0; //La vida que se resta al objetivo es cero.
		}		
		
		Stats variationTarget = new Stats( -aux, 0, 0, 0, 0); //Actualizar vida actual del objetivo.
		
		GameManager.getManager().getActions().add(new Action(variationTarget, actionType, skillType, user, target));
		target.getState().setSuggestion(States.PARALYZED); //Intento de paralizar.
		informPlayer(user,target);

	}

}

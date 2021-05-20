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

public class ArtoriasSword extends ActiveItemDecorator{ //Ignora toda la defensa y confunde al enemigo.

	public ArtoriasSword() {
		this(null);
	}
	public ArtoriasSword(Item equipment) {
		super(equipment, "Artorias Sword", "Dark Void", new Stats(0, 0, 40, 0, 0), ActionType.OFFENSIVE, SkillType.PHYSICAL, Tier.S);
	}

	public void useSkill(Character user, Character target) {
		int aux = user.getEquipment().getAttack(); //Resultado del combate, ignorando toda la defensa del objetivo.
		
		Stats variationTarget = new Stats( -aux, 0, 0, 0, 0); //Actualizar vida actual del objetivo.

		GameManager.getManager().getActions().add(new Action(variationTarget, actionType, skillType, user, target));
		target.getState().setSuggestion(States.CONFUSED); //Intento de confundir.
		informPlayer(user,target);

	}

}

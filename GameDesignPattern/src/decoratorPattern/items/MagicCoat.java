package decoratorPattern.items;

import java.util.List;

import base.*;
import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class MagicCoat extends ActiveItemDecorator{ //Defiende de la primera habilidad leve recibida

	public MagicCoat() {
		this(null);
	}
	public MagicCoat(Item equipment) {
		super(equipment, "MagicCoat", "Magic coat", new Stats(0, 0, 0, 5, 0), ActionType.DEFENSIVE, SkillType.MAGIC, Tier.C);
	}

	@Override
	public void useSkill(Character user, Character target) {
		List<Action> actions = GameManager.getManager().getActions();
		for(int i = 0; i < actions.size(); i++) {
			//Una accion dirigida al jugador que usa el escudo
			if(actions.get(i).getActionType()==ActionType.OFFENSIVE && actions.get(i).getTarget() ==user) {
				//Si va a recibir menos de 10 de da�o, no le afecta la habilidad
				if(actions.get(i).getVariation().getLife()>-10) {
					actions.get(i).getVariation().setLife(0);
					inform(user,target);
					break; //Solo funciona con la primera
				}
			}
		}
	}
}

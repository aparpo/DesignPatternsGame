package decoratorPattern.items;

import java.util.List;

import base.*;
import base.Character;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class Shield extends ActiveItemDecorator{ //Defiende de la primera habilidad leve recibida

	public Shield(Item equipment) {
		super(equipment, "Shield", "Shield", 0, 0, 0, 5, 0, ActionType.DEFENSIVE, SkillType.PHYSICAL, Tier.C);
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
					break; //Solo funciona con la primera
				}
			}
		}
	}
}

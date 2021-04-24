package decoratorPattern.items;

import java.util.List;

import base.Character;
import decoratorPattern.Action;
import decoratorPattern.ActionType;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Item;
import singletonPattern.GameManager;

public class Shield extends ActiveItemDecorator{ //Defiende de habilidades fisicas

	public Shield(Item equipment) {
		super(equipment, "Shield", "Shield", 0, 0, 0, 10, 0);
	}

	@Override
	public void useSkill(Character user, Character target) {
		List<Action> actions = GameManager.getManager().getActions();
		for(int i = 0; i < actions.size(); i++) {
			//Una accion dirigida al jugador que usa el escudo
			if(actions.get(i).getActionType()==ActionType.OFFENSIVE && actions.get(i).getTarget() ==user) {
				//Si va a recibir menos de 10 de daño, no le afecta la habilidad
				if(actions.get(i).getVariation().getLife()>-10) {
					actions.remove(i);
					break;
				}
			}
		}
	}

}

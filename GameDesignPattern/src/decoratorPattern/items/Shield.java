package decoratorPattern.items;

import java.util.List;

import base.Action;
import base.ActionType;
import base.Character;
import base.SkillType;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Equipment;
import singletonPattern.GameManager;

public class Shield extends ActiveItemDecorator{ //Defiende de la primera habilidad leve recibida

	public Shield(Equipment equipment) {
		super(equipment, "Shield", "Shield", 0, 0, 0, 5, 0, ActionType.DEFENSIVE, SkillType.PHYSICAL);
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
					break; //Solo funciona con la primera
				}
			}
		}
	}
}

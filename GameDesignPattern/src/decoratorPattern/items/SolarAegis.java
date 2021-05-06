package decoratorPattern.items;

import java.util.List;

import base.Action;
import base.ActionType;
import base.Character;
import base.EquipmentTier;
import base.SkillType;
import base.Stats;
import decoratorPattern.*;
import singletonPattern.GameManager;

public class SolarAegis extends ActiveItemDecorator{ //Devuelve daño de un ataque

	public SolarAegis(Equipment equipment) {
		super(equipment, "Solar Aegis", "Aegis desire", 0, 0, 0, 20, 0, ActionType.DEFENSIVE, SkillType.PHYSICAL, EquipmentTier.A);
	}

	@Override
	public void useSkill(Character user, Character target) {
		List<Action> actions = GameManager.getManager().getActions();
		for(int i = 0; i < actions.size(); i++) {
			//Una accion ofensiva y fisica dirigida al jugador que usa el objeto
			if(actions.get(i).getActionType()==ActionType.OFFENSIVE &&actions.get(i).getSkillType()==SkillType.PHYSICAL
			&& actions.get(i).getTarget() ==user) {
				if(actions.get(i).getVariation().getAttack()<user.getEquipment().getDefense()) { //Comprueba que haya defensa de sobra
					//Devuelve un ataque con la defensa de sobra a cada enemigo
					Stats variation = new Stats(user.getEquipment().getDefense()-actions.get(i).getVariation().getAttack(),0,0,0,0);
					actions.add(new Action(variation, actionType, skillType, user, target));
				}
			}
		}
	}

}

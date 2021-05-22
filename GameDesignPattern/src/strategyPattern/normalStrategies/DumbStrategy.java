package strategyPattern.normalStrategies;

import java.util.List;

import base.ActionType;
import base.Character;
import base.Enemy;
import base.Player;
import decoratorPattern.ActiveItemDecorator;
import strategyPattern.DecisionTemplate;

public class DumbStrategy extends DecisionTemplate{
	
//No analiza de ninguna manera la situacion
	@Override
	protected int worthAttack(Enemy user, Player player) {
		return 0;
	}
	@Override
	protected int worthDefend(Enemy user, Player player) {
		return 0;
	}
	@Override
	protected int worthNeutral(Enemy user, Player player) {
		return 0;
	}
//Usa un objeto aleatorio de entre su lista
	@Override
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		int randomResult = (int)(Math.random()*skills.size());
		if(skills.get(randomResult).getActionType() == ActionType.NEUTRAL) {
			skills.get(randomResult).useSkill(user, user);
		}else {
			skills.get(randomResult).useSkill(user, target);
		}
	}

	public String toString() {
		return "Dumb";
	}
}

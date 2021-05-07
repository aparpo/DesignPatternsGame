package statePattern;

import base.Action;
import base.ActionType;
import base.SkillType;
import base.Stats;
import singletonPattern.GameManager;

public class StateSeriouslyPosioned extends AbstractState implements CharacterState{

	public StateSeriouslyPosioned() {}
	public StateSeriouslyPosioned(State state) {
		super(state);
	}
	public void process() {
		if(suggestion == States.STANDARD) {
			standard();
		}else if(this.state.getTurnos() <= 0) {
			poisoned();
		}
		
	}

	
	public Action effect(Action action) {
		GameManager.getManager().getActions().add(new Action(new Stats((int)(action.getTarget().getEquipment().getMaxLife()*0.1),0,0,0,0), ActionType.NEUTRAL,SkillType.MAGIC, action.getUser(),action.getUser()));
		return action;
	}
	protected void standard() {
		System.out.println("El jugador ya no esta envenenado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	protected void poisoned() {
		System.out.println("El jugador ya no esta seriamente envenenado, pero sigue envenenado");
		this.state.setTurnos(this.state.getTurnos()+1);
		this.state.setState(this.state.getPossibleState(States.POISONED));
	}

}

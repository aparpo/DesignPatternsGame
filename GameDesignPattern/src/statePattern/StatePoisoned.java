package statePattern;

import base.Action;
import base.ActionType;
import base.SkillType;
import base.Stats;
import singletonPattern.GameManager;

public class StatePoisoned extends AbstractState implements CharacterState{

	
	public StatePoisoned() {}
	public StatePoisoned(State state) {
		super(state);
	}
	
	public void process() {
		if(suggestion == States.STANDARD || this.state.getTurnos() <= 0) {
			standard();
		}else if(suggestion == States.POISONED) {
			this.state.setTurnos(this.state.getTurnos()+1);
			
		}
	}
	
	public Action effect(Action action) {
		GameManager.getManager().getActions().add(new Action(new Stats(-2,0,0,0,0), ActionType.NEUTRAL,SkillType.MAGIC, action.getUser(),action.getUser()));
		return action;
	}

	protected void standard() {
		System.out.println("El jugador ya no esta envenenado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	protected void seriouslyPosioned() {
		System.out.println("El jugador esta gravemente envenenado");
		this.state.setState(this.state.getPossibleState(States.SERIOUSLYPOISONED));
	}
	
}

package statePattern;

import decoratorPattern.Action;
import decoratorPattern.ActionType;
import decoratorPattern.SkillType;
import decoratorPattern.Stats;

public class StatePoisoned extends AbstractState implements CharacterState{
	private State state;
	public StatePoisoned() {}
	public StatePoisoned(State state) {
		this.state = state;
	}
	
	public void process(States suggestion) {
		if(suggestion == States.STANDARD || this.state.getTurnos() <= 0) {
			standard();
		}else if(suggestion == States.POISONED) {
			this.state.setTurnos(this.state.getTurnos()+1);
		}
	}
	
	public Action effect(Action action) {
		
		Action veneno = new Action(new Stats(-2,0,0,0,0), ActionType.NEUTRAL,SkillType.MAGIC, action.getUser(),action.getUser());
		return action;
	}

	protected void standard() {
		System.out.println("El jugador ya no esta envenenado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	
}

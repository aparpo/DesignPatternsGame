package statePattern;

import base.Action;

public class StateStandard extends AbstractState{

	
	public StateStandard() {}
	public StateStandard(State state) {
		super(state);
	}
	public void process() {
		if(suggestion != States.STANDARD && suggestion != null) {
			this.state.setState(this.state.getPossibleState(suggestion));
			System.out.println("El jugador esta "+suggestion.getDesc());
			this.state.setTurns(2);
		}
		suggestion = null;
		
	}
	
public Action effect(Action action) {
		return action;
	}


}

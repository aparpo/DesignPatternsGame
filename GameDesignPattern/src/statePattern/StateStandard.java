package statePattern;

import decoratorPattern.Action;

public class StateStandard extends AbstractState implements CharacterState{
	private State state;
	public StateStandard() {}
	public StateStandard(State state) {
		this.state = state;
	}
	public void process(States suggestion) {
		if(suggestion != States.STANDARD) {
			this.state.setState(this.state.getPossibleState(suggestion));
		}
		
	}
	public Action effect(Action action) {
		return action;
	}
	
	
	protected void paralyzed() {
		System.out.println("El jugador esta paralizado");
		this.state.setState(this.state.getPossibleState(States.PARALYZED));
	}
	protected void poisoned() {
		System.out.println("El jugador esta envenenado");
		this.state.setState(this.state.getPossibleState(States.POISONED));
	}
	protected void confused() {
		System.out.println("El jugador esta confundido");
		this.state.setState(this.state.getPossibleState(States.CONFUSED));
	}
	protected void furious() {
		System.out.println("El jugador esta furioso");
		this.state.setState(this.state.getPossibleState(States.FURIOUS));
	}


}

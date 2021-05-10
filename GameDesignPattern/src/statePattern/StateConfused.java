package statePattern;

import base.Action;

public class StateConfused extends AbstractState{
	
	public StateConfused() {}
	public StateConfused(State state) {
		super(state);
	}
	
	public void process() {
		if(suggestion == States.STANDARD) {
			standard();
		}else if(suggestion == States.CONFUSED) {
			confused();
		}
		
		if(this.state.getTurns() <= 0) {
			standard();
		}
		suggestion = null;
	}
	
	@Override
	public Action effect(Action action) {
		System.out.println("Estas confundido, tu ataque puede fallar este turno");
		this.state.setTurns(this.state.getTurns()-1);
		
		//Cambia el objetivo al usuario con un 60% de probabilidad
		if(Math.random() < 0.6) { 
			action.setTarget(action.getUser());
		}
		return action;
	}
	
	protected void standard() {
		System.out.println("El jugador ya no esta confundido");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	protected void confused() {
		System.out.println("El jugador esta aun mas confundido");
		this.state.setTurns(this.state.getTurns()+1);
	}
	
	
	
}

package statePattern;

import base.Action;

public class StateConfused extends AbstractState implements CharacterState{
	
	private State state;
	
	public StateConfused() {}
	public StateConfused(State state) {
		this.state = state;
		//this.state.setTurnos(2);
	}
	
	public void process(States suggestion) {
		if(suggestion == States.STANDARD) {
			standard();
		}else if(suggestion == States.CONFUSED) {
			confused();
		}
		
		if(this.state.getTurnos() <= 0) {
			standard();
		}
	}
	
	@Override
	public Action effect(Action action) {
		System.out.println("Estas confundido, tu ataque puede fallar este turno");
		this.state.setTurnos(this.state.getTurnos()-1);
		
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
		this.state.setTurnos(this.state.getTurnos()+1);
	}
	
	
	
}

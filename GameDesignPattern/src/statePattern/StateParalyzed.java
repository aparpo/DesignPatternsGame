package statePattern;

import base.Action;

public class StateParalyzed extends AbstractState implements CharacterState{
	
	
	public StateParalyzed() {}
	public StateParalyzed(State state) {
		super(state);
	}
	
	public void process() {
		if(suggestion == States.STANDARD || this.state.getTurnos() <= 0) {
			standard();
		}else if(suggestion == States.PARALYZED) {
			this.state.setTurnos(this.state.getTurnos()+1);
		}
	}
	
	public Action effect(Action action) {
		if((int) Math.random()*1 == 0) {
			action.getVariation().backToNormal();
			action.getVariation().setLife(0);
		}
		return action;
	}
	
	protected void standard() {
		System.out.println("El jugador ya no esta paralizado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	
	
}

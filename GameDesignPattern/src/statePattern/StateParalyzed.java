package statePattern;

import base.Action;

public class StateParalyzed extends AbstractState implements CharacterState{
	
	
	public StateParalyzed() {}
	public StateParalyzed(State state) {
		super(state);
	}
	
	public void process() {
		if(suggestion == States.STANDARD || this.state.getTurns() <= 0) {
			standard();
		}else if(suggestion == States.PARALYZED || suggestion == States.SERIOUSLYPARALYZED) {
			seriouslyParalyzed();
		}
		suggestion = null;
	}
	
	public Action effect(Action action) {
		if((int) Math.random()*1 == 0) {
			action.getVariation().backToNormal();
			action.getVariation().setLife(0);
		}
		this.state.setTurns(this.state.getTurns()-1);
		return action;
	}
	
	protected void standard() {
		System.out.println("El jugador ya no esta paralizado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	protected void seriouslyParalyzed() {
		System.out.println("El jugador esta gravemente paralizado");
		this.state.setState(this.state.getPossibleState(States.SERIOUSLYPARALYZED));
		this.state.setTurns(this.state.getTurns()+1);
	}
	
}

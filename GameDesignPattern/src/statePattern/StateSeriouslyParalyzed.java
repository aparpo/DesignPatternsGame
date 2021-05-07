package statePattern;

import base.Action;

public class StateSeriouslyParalyzed extends AbstractState implements CharacterState{

	
	public void process() {
		if(suggestion == States.STANDARD) {
			standard();
		}else if(this.state.getTurnos() <= 0) {
			paralyzed();
		}
	}

	
	public Action effect(Action action) {
		action.getVariation().backToNormal();
		action.getVariation().setLife(0);
		return action;
	}
	protected void standard() {
		System.out.println("El jugador ya no esta paralizado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	protected void paralyzed() {
		System.out.println("El jugador ya no esta seriamente paralizado, pero sigue paralizado");
		this.state.setTurnos(this.state.getTurnos()+1);
		this.state.setState(this.state.getPossibleState(States.PARALYZED));
	}
}

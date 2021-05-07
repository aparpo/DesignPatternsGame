package statePattern;

import base.Action;

public class StateSeriouslyParalyzed extends AbstractState implements CharacterState{

	
	public void process() {
		if(suggestion == States.STANDARD) {
			standard();
		}else if(this.state.getTurns() <= 0) {
			paralyzed();
		}
		suggestion = null;
	}

	
	public Action effect(Action action) {
		//Devuelve una accion inutilizada
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
		this.state.setState(this.state.getPossibleState(States.PARALYZED));
		this.state.setTurns(1);
	}
}

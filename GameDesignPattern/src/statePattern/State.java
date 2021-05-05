package statePattern;

import java.util.ArrayList;
import java.util.List;
import base.*;

public class State {
	private CharacterState state;

	private List<CharacterState> possibleStates = new ArrayList<CharacterState>();

	private int turnos;
	
	public void process(States suggestion) {
		this.state.process(suggestion);
	}
	
	public State() {
		this.state = new StateStandard(this);
		this.possibleStates.add(state);
		this.possibleStates.add(new StateConfused(this));
		this.possibleStates.add(new StateFurious(this));
		this.possibleStates.add(new StateParalyzed(this));
		this.possibleStates.add(new StatePoisoned(this));
		this.turnos = 0;
	}
	
	
	public CharacterState getState() {
		return state;
	}

	public void setState(CharacterState state) {
		this.state = state;
		this.turnos = 2;
	}
	
	public CharacterState getPossibleState(States desired) {
		return possibleStates.get(desired.ordinal());
	}

	public int getTurnos() {
		return turnos;
	}

	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}
	
	public Action effect(Action action) {
		return state.effect(action);
	}

	
}

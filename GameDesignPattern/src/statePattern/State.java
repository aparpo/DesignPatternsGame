package statePattern;

import java.util.ArrayList;
import java.util.List;
import base.*;

public class State {
	private CharacterState state;

	private List<CharacterState> possibleStates = new ArrayList<CharacterState>();

	private int turns;
	
	public void process() {
		this.state.process();
	}
	
	public State() {
		this.state = new StateStandard(this);
		this.possibleStates.add(state);
		this.possibleStates.add(new StateConfused(this));
		this.possibleStates.add(new StateFurious(this));
		this.possibleStates.add(new StateParalyzed(this));
		this.possibleStates.add(new StatePoisoned(this));
		this.possibleStates.add(new StateSeriouslyPosioned(this));
		this.turns = 0;
	}
	
	public CharacterState getState() {
		return state;
	}

	public void setState(CharacterState state) {
		this.state = state;
		this.turns = 2;
	}
	
	public CharacterState getPossibleState(States desired) {
		return possibleStates.get(desired.ordinal());
	}
	public String getStateName() {
		return state.getStateName();
	}

	public int getTurns() {
		return turns;
	}

	public void setTurns(int turnos) {
		this.turns = turnos;
	}
	
	public Action effect(Action action) {
		return state.effect(action);
	}
	
	public void setSuggestion(States suggestion) {
		state.setSuggestion(suggestion);
	}

	
}

package statePattern;

import base.Action;

public interface CharacterState {
	public void process();
	public Action effect(Action action);
	public void setSuggestion(States suggestion);
	public States getSuggestion();
	public String getStateName();
}

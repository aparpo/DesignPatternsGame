package statePattern;

import base.Action;

public interface CharacterState {
	public void process(States suggestion);
	public Action effect(Action action);
}

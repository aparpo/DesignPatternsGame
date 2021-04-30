package statePattern;

import decoratorPattern.Action;

public interface CharacterState {
	public void process(States suggestion);
	public Action effect(Action action);
}

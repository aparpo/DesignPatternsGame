package com.utad.project.statePattern;

import com.utad.project.base.Action;

public interface CharacterState {
	public void process();
	public Action effect(Action action);
	public void setSuggestion(States suggestion);
	public States getSuggestion();
	public String getStateName();
}

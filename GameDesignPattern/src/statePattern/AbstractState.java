package statePattern;

import base.Action;

public abstract class AbstractState implements CharacterState{
	public abstract void process(States suggestion);
	public abstract Action effect(Action action);
	
	
	//private
	protected  void paralyzed() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
	protected  void poisoned() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
	protected  void confused() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
	protected  void standard() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
	protected  void furious() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
}

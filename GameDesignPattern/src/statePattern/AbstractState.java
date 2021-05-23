package statePattern;

import base.Action;

public abstract class AbstractState implements CharacterState{
	
	protected State state;
	protected States suggestion; //proximo estado recomendado
	protected String stateName;
	
	public AbstractState() {}
	public AbstractState(State state,String stateName) {
		this.state = state;
		this.stateName = stateName;
	}
	
	public abstract void process();
	public abstract Action effect(Action action);
	
	
	//private
	protected  void paralyzed() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
	protected  void seriouslyParalyzed() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
	protected  void poisoned() throws Exception {
		throw(new Exception("Transicion ilegal"));
	}
	protected  void seriouslyPoisoned() throws Exception {
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
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public States getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(States suggestion) {
		this.suggestion = suggestion;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
}

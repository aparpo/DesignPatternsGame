package statePattern;

import base.Action;

public class StateFurious extends AbstractState{
	
	public StateFurious() {}
	public StateFurious(State state) {
		super(state);
	}
	
	public void process() {		
		if(suggestion == States.SERIOUSLYPARALYZED) {
			seriouslyParalyzed();
		}else if(this.state.getTurns() <= 0) {
			if(Math.random() <= 0.5) {
				standard();
			}else {
				confused();
			}
		}
		suggestion = null;
	}
	
	public Action effect(Action action) {
		action.getVariation().setAttack(action.getVariation().getAttack()*2);
		this.state.setTurns(this.state.getTurns()-1);
		return action;
	}

	protected void confused() {
		System.out.println("El jugador acaba cansado y queda confundido");
		this.state.setState(this.state.getPossibleState(States.CONFUSED));
		this.state.setTurns(1);
	}

	protected void standard() {
		System.out.println("El jugador ya no esta furioso");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	
	protected  void seriouslyParalyzed() {
		System.out.println("Furia interrumpida, el jugador esta seriamente paralizado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
		this.state.setTurns(2);
	}
	
	
}

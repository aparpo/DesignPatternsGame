package statePattern;

import decoratorPattern.Action;

public class StateFurious extends AbstractState implements CharacterState{
	boolean damageUpdate;
	private State state;
	public StateFurious() {}
	public StateFurious(State state) {
		this.state = state;
		this.state.setTurnos(1);
	}
	
	public void process(States suggestion) {		
		if(suggestion == States.STANDARD) {
			standard();
		}else if(this.state.getTurnos() <= 0) {
			if((int)Math.random()*1 == 0) {
				standard();
			}else {
				confused();
			}
			damageUpdate = false;
		}
	}
	
	public Action effect(Action action) {
		if(damageUpdate == false){
			action.getVariation().setAttack(action.getVariation().getAttack()*2);
			damageUpdate = true;
		}
		return action;
	}

	protected void confused() {
		System.out.println("El jugador esta confundido");
		this.state.setState(this.state.getPossibleState(States.CONFUSED));
	}

	protected void standard() {
		System.out.println("El jugador ya no esta furioso");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	public boolean getDamageUpdate() {
		return damageUpdate;
	}
	public void setDamageUpdate(boolean damageUpdate) {
		this.damageUpdate = damageUpdate;
	}
	
	
}

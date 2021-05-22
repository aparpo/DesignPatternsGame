package statePattern;

import base.Action;
import base.ActionType;
import base.SkillType;
import base.Stats;
import singletonPattern.GameManager;

public class StatePoisoned extends AbstractState{

	
	public StatePoisoned() {}
	public StatePoisoned(State state) {
		super(state);
	}
	
	public void process() {
		if(suggestion == States.STANDARD || this.state.getTurns() <= 0) {
			standard();
		}else if(suggestion == States.POISONED) {
			this.state.setTurns(this.state.getTurns()+1);
		}
		suggestion = null;
	}
	
	public Action effect(Action action) {
		//Nueva accion que afecta al usuario restandole vida
		GameManager.getManager().getActions().add(new Action(new Stats(-2,0,0,0,0), 
				ActionType.NEUTRAL,SkillType.MAGIC, null,action.getUser()));
		GameManager.getManager().informPlayer(action.getUser().getName()+" is damaged by poison");
		this.state.setTurns(this.state.getTurns()-1);
		return action;
	}

	protected void standard() {
		System.out.println("El jugador ya no esta envenenado");
		this.state.setState(this.state.getPossibleState(States.STANDARD));
	}
	protected void seriouslyPosioned() {
		System.out.println("El jugador esta gravemente envenenado");
		this.state.setState(this.state.getPossibleState(States.SERIOUSLYPOISONED));
		this.state.setTurns(this.state.getTurns()+1);
		
	}
	
}

package StatePattern;

public class State {
	private CharacterState state;
	private CharacterStateTransition stateCharacter;
	private Character player = new Character();
	
	public void process() {
		this.state.process();
	}
	
	public State(Character player) {
		this.player = player;
		this.state = new StandardState(this);
	}
	public void changeState(CharacterState newState) {
		if(newState instanceof StatePoisoned) {
			this.state = new StatePoisoned(this);
		}else if(newState instanceof StateParalyzed){
			this.state = new StateParalyzed(this);
		}else if(newState instanceof StateConfused) {
			this.state = new StateConfused(this);
		}
	}
	
	
	public CharacterState getState() {
		return state;
	}

	public void setState(CharacterState state) {
		this.state = state;
	}

	public void setStateCharacter(CharacterStateTransition stateCharacter) {
		this.state = stateCharacter;
	}
	
	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}

}

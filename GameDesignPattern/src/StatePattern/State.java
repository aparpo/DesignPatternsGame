package StatePattern;

public class State {
	private CharacterState state;
	private StateParalyzed Paralyzed= new StateParalyzed(this);
	private StatePoisoned Poisoned = new StatePoisoned(this);
	private StateConfused Confused = new StateConfused(this);
	private StateStandard Standard = new StateStandard(this);
	private StateFurious furious = new StateFurious(this);
	//private CharacterStateTransition stateCharacter;
	int turnos;
	private Character player = new Character();
	
	public void process() {
		this.state.process();
	}
	
	public State(Character player) {
		this.player = player;
		this.state = new StateStandard(this);
		this.Paralyzed = new StateParalyzed(this);
		this.Poisoned = new StatePoisoned(this);
		this.Confused = new StateConfused(this);
		this.Standard = new StateStandard(this);
	}
	
	
	public CharacterState getState() {
		return state;
	}

	public void setState(CharacterState state) {
		this.state = state;
	}

	public void setStateCharacter(CharacterState stateCharacter) {
		this.state = stateCharacter;
	}
	
	public Character getPlayer() {
		return player;
	}

	public void setPlayer(Character player) {
		this.player = player;
	}

	public StateParalyzed getParalyzed() {
		return Paralyzed;
	}

	public void setParalyzed(StateParalyzed paralyzed) {
		Paralyzed = paralyzed;
	}

	public StatePoisoned getPoisoned() {
		return Poisoned;
	}

	public void setPoisoned(StatePoisoned poisoned) {
		Poisoned = poisoned;
	}

	public StateConfused getConfused() {
		return Confused;
	}

	public void setConfused(StateConfused confused) {
		Confused = confused;
	}

	public StateStandard getStandard() {
		return Standard;
	}

	public void setStandard(StateStandard standard) {
		Standard = standard;
	}

	public int getTurnos() {
		return turnos;
	}

	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}

	public StateFurious getFurious() {
		return furious;
	}

	public void setFurious(StateFurious furious) {
		this.furious = furious;
	}
	
}

package statePattern;

public class StateStandard implements CharacterState{
	private State state;
	public StateStandard() {}
	public StateStandard(State state) {
		this.state = state;
	}
	
	
	public void process() {
		this.state.setTurnos(this.state.getTurnos()-1);
		if(this.state.getTurnos() == 0) {
			standard();
		}
	}
	
	public void paralyzed() {
		this.state.setStateCharacter(this.state.getParalyzed());
	}
	public void poisoned() {
		this.state.setStateCharacter(this.state.getPoisoned());
	}
	public void confused() {
		this.state.setStateCharacter(this.state.getConfused());
	}
	public void furious() {
		this.state.getFurious().setDamageUpdate(true);
		this.state.setStateCharacter(this.state.getFurious());
	}
	public void standard() {

	}
}

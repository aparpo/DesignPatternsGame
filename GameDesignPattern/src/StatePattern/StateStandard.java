package StatePattern;

public class StateStandard implements CharacterState{
	private State state;
	public StateStandard() {}
	public StateStandard(State state) {
		this.state = state;
		this.state.setTurnos(this.state.getTurnos()-1);
	}
	
	
	public void process() {
		this.state.setTurnos(this.state.getTurnos()-1);
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
	public void standard() {

	}
}

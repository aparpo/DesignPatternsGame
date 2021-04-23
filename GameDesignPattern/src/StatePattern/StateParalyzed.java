package StatePattern;

public class StateParalyzed implements CharacterState{
	private State state;
	public StateParalyzed() {}
	public StateParalyzed(State state) {
		this.state = state;
	}

	public void process() {
		// Paralyzed
		System.out.println("Estas paralizado, no puedes hacer nada este turno");
		this.state.setTurnos(this.state.getTurnos()-1);
	}
	public void paralyzed() {
		
	}
	public void poisoned() {
		
	}
	public void confused() {
		
	}
	public void standard() {
		// TODO Auto-generated method stub
		System.out.println("El jugador ya no esta paralizado");
		this.state.setStateCharacter(this.state.getStandard());
	}
	
}

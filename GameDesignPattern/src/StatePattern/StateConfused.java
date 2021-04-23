package StatePattern;

public class StateConfused implements CharacterState{
	private State state;
	public StateConfused() {}
	public StateConfused(State state) {
		this.state = state;
		this.state.setTurnos(2);
	}
	
	public void process() {
		// Paralyzed
		System.out.println("Estas confundido, tu ataque puede fallar este turno");
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
		System.out.println("El jugador ya no esta confundido");
		this.state.setStateCharacter(this.state.getStandard());
	}
	
	
}

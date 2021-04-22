package StatePattern;

public class StateConfused implements CharacterStateTransition{
	int turnos;
	private State state;
	public StateConfused() {}
	public StateConfused(State state) {
		this.state = state;
		turnos = 1;
	}
	
	public void process() {
		// Paralyzed
		System.out.println("Estas confundido, tu ataque puede fallar este turno");
		turnos--;
	}

	public void standard() {
		// TODO Auto-generated method stub
		System.out.println("El jugador ya no esta confundido");
		this.state.setStateCharacter(new StandardState(this.state));
	}
	
	
}

package StatePattern;

public class StateParalyzed implements CharacterStateTransition{
	int turnos;
	private State state;
	public StateParalyzed() {}
	public StateParalyzed(State state) {
		this.state = state;
		turnos = 1;
	}

	public void process() {
		// Paralyzed
		System.out.println("Estas paralizado, no puedes hacer nada este turno");
		turnos--;
	}

	public void standard() {
		// TODO Auto-generated method stub
		System.out.println("El jugador ya no esta paralizado");
		this.state.setStateCharacter(new StandardState(this.state));
	}
	
}

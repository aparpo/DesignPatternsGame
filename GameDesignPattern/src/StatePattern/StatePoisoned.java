package StatePattern;

import java.time.LocalDate;

public class StatePoisoned implements CharacterStateTransition{
	int turnos;
	private State state;
	public StatePoisoned() {}
	public StatePoisoned(State state) {
		this.state = state;
		turnos = 1;
	}
	
	public void process() {
		// Poisoned
		if(this.turnos == 1) {
			System.out.println("Estas envenado, vas a perder vida");
			this.state.getPlayer().setVida(this.state.getPlayer().getVida()-2);
			turnos--;
		}else {
			this.standard();
		}
		
	}

	public void standard() {
		// TODO Auto-generated method stub
		System.out.println("El jugador ya no esta envenenado");
		this.state.setStateCharacter(new StandardState(this.state));
	}
	
}

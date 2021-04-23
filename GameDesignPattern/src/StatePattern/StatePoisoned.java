package StatePattern;

import java.time.LocalDate;

public class StatePoisoned implements CharacterState{
	private State state;
	public StatePoisoned() {}
	public StatePoisoned(State state) {
		this.state = state;
	}
	
	public void process() {
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
		System.out.println("El jugador ya no esta envenenado");
		this.state.setStateCharacter(this.state.getStandard());
	}
	
}

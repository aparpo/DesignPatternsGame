package StatePattern;


public class StatePoisoned implements CharacterState{
	private State state;
	public StatePoisoned() {}
	public StatePoisoned(State state) {
		this.state = state;
	}
	
	public void process() {
		this.state.setTurnos(this.state.getTurnos()-1);
		if(this.state.getTurnos() == 0) {
			standard();
		}
	}
	public void paralyzed() {
		
	}
	public void poisoned() {
		
	}
	public void confused() {
		
	}
	public void furious() {
		
	}
	public void standard() {
		// TODO Auto-generated method stub
		System.out.println("El jugador ya no esta envenenado");
		this.state.setStateCharacter(this.state.getStandard());
	}
	
}

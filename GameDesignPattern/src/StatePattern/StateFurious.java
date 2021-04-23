package StatePattern;

public class StateFurious implements CharacterState{
	boolean damageUpdate;
	private State state;
	public StateFurious() {}
	public StateFurious(State state) {
		this.state = state;
		this.state.setTurnos(1);
	}
	public void process() {
		// TODO Auto-generated method stub
		if(damageUpdate) {
			damageUpdate = false;
			this.state.getPlayer().setDamage(this.state.getPlayer().getDamage()*2);
		}
		this.state.setTurnos(this.state.getTurnos()-1);
		if(this.state.getTurnos() == 0) {
			this.state.getPlayer().setDamage(this.state.getPlayer().getDamage()/2);
			if(Math.random()*1== 1) {
				confused();
			}else {
				paralyzed();
			}
		}
	}

	public void paralyzed() {
		this.state.setStateCharacter(this.state.getParalyzed());
	}

	public void poisoned() {
	
	}

	public void confused() {
		// TODO Auto-generated method stub
		this.state.setStateCharacter(this.state.getConfused());
	}
	
	public void furious() {
		
	}

	public void standard() {
		
	}
	public boolean getDamageUpdate() {
		return damageUpdate;
	}
	public void setDamageUpdate(boolean damageUpdate) {
		this.damageUpdate = damageUpdate;
	}
	
}

package statePattern;

public interface CharacterState {
	public void process(/* Enum Sugerencia de estado */);
	//public void effect(Action);
	
	
	//private
	public void paralyzed();
	public void poisoned();
	public void confused();
	public void standard();
	public void furious();
}

package StatePattern;

public interface CharacterState {
	public void process();
	public void paralyzed();
	public void poisoned();
	public void confused();
	public void standard();
	public void furious();
}

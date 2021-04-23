package StatePattern;

public interface CharacterState {
	public void process();
	public void standard();
	public void paralyzed();
	public void poisoned();
	public void confused();
}

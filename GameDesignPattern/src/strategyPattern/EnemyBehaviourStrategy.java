package strategyPattern;

public interface EnemyBehaviourStrategy extends BehaviourStrategy{
	public void attack();
	public void defend();
	public void useItem();
	public void run();
}

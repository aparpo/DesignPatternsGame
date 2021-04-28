package strategyPattern;

public interface EnemyBehaviourStrategy extends BehaviourStrategy{
	public void attack(int damageDealt);
	public void defend(int damageReduced);
	public void useItem();
	public void run();
}

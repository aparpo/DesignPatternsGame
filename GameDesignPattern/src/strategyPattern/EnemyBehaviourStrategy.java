package strategyPattern;
import abstractFactoryPattern.Enemy;

public interface EnemyBehaviourStrategy extends BehaviourStrategy{
	public void attack(Enemy enemy);
	public void defend(Enemy enemy);
	public void useItem(Enemy enemy);
	public void run(Enemy enemy);
}

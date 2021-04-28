package strategyPattern;
import abstractFactoryPattern.Enemy;

public interface BehaviourStrategy {
	public void doAction(Enemy enemy);
}

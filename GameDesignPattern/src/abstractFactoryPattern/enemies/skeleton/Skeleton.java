package abstractFactoryPattern.enemies.skeleton;
import base.Enemy;
import base.Stats;
import strategyPattern.normalStrategies.AgressiveStrategy;

public abstract class Skeleton extends Enemy{
	protected final Stats skeletonBaseStats = new Stats(50, 50, 40, 10, 4);
	
	public Skeleton(String enemyName) {
		super("Skeleton");
		this.enemyName = enemyName;
		this.behaviour = new AgressiveStrategy();
	}
}

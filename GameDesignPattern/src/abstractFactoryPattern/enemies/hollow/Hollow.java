package abstractFactoryPattern.enemies.hollow;
import base.Enemy;
import base.Stats;
import decoratorPattern.items.Shield;
import strategyPattern.normalStrategies.AgressiveStrategy;

public abstract class Hollow extends Enemy{
	protected final Stats hollowBaseStats = new Stats(60, 60, 30, 30, 2);
	
	public Hollow(String enemyName) {
		super("Hollow");
		this.enemyName = enemyName;
	}
}

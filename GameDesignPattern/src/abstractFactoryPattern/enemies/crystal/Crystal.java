package abstractFactoryPattern.enemies.crystal;
import base.Enemy;
import base.Stats;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class Crystal extends Enemy{
	protected final Stats crystalBaseStats = new Stats(30, 30, 80, 15, 1);
	
	public Crystal(String enemyName) {
		super(enemyName);
	}
}

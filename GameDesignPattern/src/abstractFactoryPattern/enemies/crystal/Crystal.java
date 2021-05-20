package abstractFactoryPattern.enemies.crystal;
import base.Enemy;
import base.Stats;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class Crystal extends Enemy{
	protected final Stats crystalBaseStats = new Stats(30, 30, 110, 15, 1);
	
	public Crystal(String enemyName) {
		super("Crystal Enemy");
		this.enemyName = enemyName;
	}
}

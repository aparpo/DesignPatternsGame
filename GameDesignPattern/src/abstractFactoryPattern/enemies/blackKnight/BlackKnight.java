package abstractFactoryPattern.enemies.blackKnight;
import base.Enemy;
import base.Stats;
import decoratorPattern.items.Bow;
import decoratorPattern.items.Shield;
import strategyPattern.normalStrategies.AgressiveStrategy;

public abstract class BlackKnight extends Enemy{
	protected static final Stats blackKnightBaseStats = new Stats(60, 60, 20, 20, 2);
	
	public BlackKnight(String enemyName) {
		super("Black Knight");
		this.enemyName = enemyName;
	}
}

package abstractFactoryPattern.enemies.blackKnight;
import base.Enemy;
import base.Stats;
import decoratorPattern.items.Bow;
import decoratorPattern.items.Shield;
import strategyPattern.normalStrategies.AgressiveStrategy;

public abstract class BlackKnight extends Enemy{
	protected static final Stats blackKnightBaseStats = new Stats(300, 300, 80, 80, 20);
	
	public BlackKnight(String enemyName) {
		super("Black Knight");
		this.enemyName = enemyName;
		this.behaviour = new AgressiveStrategy();
	}
}

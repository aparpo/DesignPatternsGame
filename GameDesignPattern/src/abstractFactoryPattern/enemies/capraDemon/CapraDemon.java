package abstractFactoryPattern.enemies.capraDemon;
import base.Enemy;
import base.Stats;

public abstract class CapraDemon extends Enemy{
	protected final Stats capraDemonBaseStats = new Stats(70, 70, 40, 20, 1);
	
	public CapraDemon(String enemyName) {
		super("Capra Demon");
		this.enemyName = enemyName;
	}
}

package abstractFactoryPattern.enemies.capraDemon;
import base.Enemy;
import base.Stats;

public abstract class CapraDemon extends Enemy{
	protected final Stats capraDemonBaseStats = new Stats(350, 350, 85, 50, 10);
	
	public CapraDemon(String enemyName) {
		super("Capra Demon");
		this.enemyName = enemyName;
	}
}

package abstractFactoryPattern.enemies.giant;
import base.Enemy;
import base.Stats;

public abstract class Giant extends Enemy{
	protected final Stats giantBaseStats = new Stats(100, 100, 40, 65, 1);
	
	public Giant(String enemyName) {
		super(enemyName);
	}
}

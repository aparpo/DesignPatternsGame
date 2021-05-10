package abstractFactoryPattern.enemies.giant;
import base.Enemy;
import base.Stats;

public class Giant extends Enemy{
	protected final Stats giantBaseStats = new Stats(500, 500, 50, 95, 5);
	
	public Giant(String enemyName) {
		super("Giant");
		this.enemyName = enemyName;
	}
}

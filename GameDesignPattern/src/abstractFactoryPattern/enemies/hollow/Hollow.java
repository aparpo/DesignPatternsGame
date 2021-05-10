package abstractFactoryPattern.enemies.hollow;
import base.Enemy;
import base.Stats;

public class Hollow extends Enemy{
	protected final Stats hollowBaseStats = new Stats(250, 250, 50, 50, 25);
	
	public Hollow(String enemyName) {
		super("Hollow");
		this.enemyName = enemyName;
	}
}

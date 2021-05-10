package abstractFactoryPattern.enemies.crystal;
import base.Enemy;
import base.Stats;

public class Crystal extends Enemy{
	protected final Stats crystalBaseStats = new Stats(100, 100, 110, 15, 50);
	
	public Crystal(String enemyName) {
		super("Crystal Enemy");
		this.enemyName = enemyName;
	}
}

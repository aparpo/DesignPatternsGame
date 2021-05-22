package abstractFactoryPattern.enemies.bosses;
import base.Enemy;

public abstract class Boss extends Enemy{

	public Boss(String bossName) {
		super(bossName);
	}
}

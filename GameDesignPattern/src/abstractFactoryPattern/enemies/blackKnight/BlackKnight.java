package abstractFactoryPattern.enemies.blackKnight;
import base.Enemy;
import base.Stats;

public class BlackKnight extends Enemy{
	protected final Stats blackKnightBaseStats = new Stats(300, 300, 80, 80, 20);
	
	public BlackKnight(String enemyName) {
		super("Black Knight");
		this.enemyName = enemyName;
	}
}

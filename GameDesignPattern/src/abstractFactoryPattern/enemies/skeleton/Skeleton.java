package abstractFactoryPattern.enemies.skeleton;
import base.Enemy;
import base.Stats;

public class Skeleton extends Enemy{
	protected final Stats skeletonBaseStats = new Stats(200, 200, 80, 30, 40);
	
	public Skeleton(String enemyName) {
		super("Skeleton");
		this.enemyName = enemyName;
	}
}

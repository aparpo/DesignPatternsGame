package abstractFactoryPattern.enemies.skeleton;
import base.Enemy;
import base.Stats;

public abstract class Skeleton extends Enemy{
	protected final Stats skeletonBaseStats = new Stats(50, 50, 40, 10, 4);
	
	public Skeleton(String enemyName) {
		super("Skeleton");
		this.enemyName = enemyName;
	}
}

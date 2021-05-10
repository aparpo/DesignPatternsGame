package abstractFactoryPattern.enemies.skeleton;
import base.Enemy;
import base.Stats;

public class Skeleton extends Enemy{
	protected final Stats skeletonBaseStats = new Stats(200, 200, 80, 30, 40);
	protected String skeletonName;
	
	public Skeleton(String skeletonName) {
		super("Skeleton");
		this.skeletonName = skeletonName;
	}
}

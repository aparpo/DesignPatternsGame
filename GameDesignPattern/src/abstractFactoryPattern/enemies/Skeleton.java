package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Enemy;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class Skeleton extends Enemy{
	protected String skeletonType;

	public Skeleton(String name, Stats stats, ActiveItemDecorator weapon, String skeletonType) {
		super(name, stats, weapon);
		this.skeletonType = skeletonType;
	}

	public String getSkeletonType() {
		return skeletonType;
	}

	public void setSkeletonType(String skeletonType) {
		this.skeletonType = skeletonType;
	}
	
}

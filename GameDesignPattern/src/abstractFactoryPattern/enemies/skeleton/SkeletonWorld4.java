package abstractFactoryPattern.enemies.skeleton;

import abstractFactoryPattern.World;
import decoratorPattern.RegularItem;
import decoratorPattern.items.RatCrossbow;

public class SkeletonWorld4 extends Skeleton{

	public SkeletonWorld4() {
		super("Toxic Skeleton");
		this.equipment = new RegularItem(equipment, "custom",levelStats(skeletonBaseStats, World.WORLD4));
		this.equipment =  new RatCrossbow(equipment);
	}
	
}

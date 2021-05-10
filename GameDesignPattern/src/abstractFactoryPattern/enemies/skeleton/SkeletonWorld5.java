package abstractFactoryPattern.enemies.skeleton;

import abstractFactoryPattern.World;
import decoratorPattern.RegularItem;

public class SkeletonWorld5 extends Skeleton{

	public SkeletonWorld5() {
		super("Toxic Skeleton");
		this.equipment = new RegularItem(equipment, "custom",levelStats(skeletonBaseStats, World.WORLD1));
		
	}
}

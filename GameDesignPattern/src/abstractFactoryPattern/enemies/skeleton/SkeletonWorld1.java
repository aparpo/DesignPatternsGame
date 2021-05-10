package abstractFactoryPattern.enemies.skeleton;

import abstractFactoryPattern.World;
import base.Enemy;
import base.Stats;
import decoratorPattern.RegularItem;
import decoratorPattern.items.*;

public class SkeletonWorld1 extends Skeleton{
	public SkeletonWorld1() {
		super("Skeleton");
		this.equipment = new RegularItem(equipment, "custom",levelStats(skeletonBaseStats, World.WORLD1));
	}
}

package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class SkeletonWorld3 extends Skeleton{

	public SkeletonWorld3() {
		super("Toxic Skeleton");
		this.equipment = new RegularItem(equipment, "custom",levelStats(skeletonBaseStats, World.WORLD3));
		this.equipment =  new RatCrossbow(equipment);
	}
}

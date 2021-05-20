package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class SkeletonWorld2 extends Skeleton{

	public SkeletonWorld2() {
		super("Healer Skeleton");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(skeletonBaseStats, World.WORLD2));
	}
}

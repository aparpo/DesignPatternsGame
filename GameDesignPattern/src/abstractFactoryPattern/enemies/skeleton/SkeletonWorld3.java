package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class SkeletonWorld3 extends Skeleton{

	public SkeletonWorld3() {
		super("Wheel Skeleton");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(skeletonBaseStats, World.WORLD2));
		this.behaviour = new AgressiveStrategy();
		this.equipment = new LongSword(this.equipment);	
	}
}

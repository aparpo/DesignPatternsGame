package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class SkeletonBoss extends Skeleton{
	
	public SkeletonBoss() {
		super("Skeleton Boss");
		this.equipment = new RegularItem(equipment, "Skeleton Boss",levelStats(skeletonBaseStats,World.BOSS));
		this.equipment = new DemonSpear(this.equipment);	
	}
}

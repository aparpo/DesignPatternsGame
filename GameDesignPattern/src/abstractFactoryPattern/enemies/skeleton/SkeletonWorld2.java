package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class SkeletonWorld2 extends Skeleton{

	public SkeletonWorld2() {
		super("Skeleton de Fuego");
		this.equipment = new RegularItem(equipment, "custom",levelStats(skeletonBaseStats, World.WORLD2));
	}
}

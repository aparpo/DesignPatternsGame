package abstractFactoryPattern.enemies.skeleton;

import base.Enemy;
import base.Stats;
import decoratorPattern.RegularItem;
import decoratorPattern.items.*;

public class SkeletonWorld1 extends Enemy{
	public SkeletonWorld1() {
		super("Skeleton");
		this.equipment = new RegularItem(equipment, "custom",new Stats(50, 60, 10, 10 ,5));
		this.equipment =  new LongSword(equipment);
		this.equipment = new Shield(equipment);
	}
}

package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.behaviours.*;

public class SkeletonWorld3 extends Skeleton{

	public SkeletonWorld3() {
		super("Wheel Skeleton");
		this.equipment = new BaseEquipment(this.equipment, "Base Equipment", levelStats(skeletonBaseStats, World.WORLD2));
		this.behaviour = new AgressiveBehaviour();
		this.equipment = new LongSword(this.equipment);	
	}
}

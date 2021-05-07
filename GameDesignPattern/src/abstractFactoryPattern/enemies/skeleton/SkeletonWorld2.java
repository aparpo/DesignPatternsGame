package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.behaviours.*;

public class SkeletonWorld2 extends Skeleton{

	public SkeletonWorld2() {
		super("Skeleton");
		this.skeletonName = skeletonName;
		this.equipment = new RegularItem("custom",new Stats(300, 200, 80, 30 ,40), equipment);
		this.equipment =  new Bow(equipment);
		this.equipment = new Shield(equipment);
	}
}

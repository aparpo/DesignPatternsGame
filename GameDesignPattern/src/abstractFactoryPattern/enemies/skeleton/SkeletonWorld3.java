package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class SkeletonWorld3 extends Enemy{

	public SkeletonWorld3() {
		super("Skeleton toxico");
		this.equipment = new RegularItem(equipment, "custom",new Stats(50, 60, 10, 10 ,5));
		this.equipment =  new RatCrossbow(equipment);
		this.equipment = new Shield(equipment);
	}
}

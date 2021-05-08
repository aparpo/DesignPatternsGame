package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class SkeletonWorld2 extends Enemy{

	public SkeletonWorld2() {
		super("Skeleton de Fuego");
		this.equipment = new RegularItem(equipment, "custom",new Stats(300, 200, 80, 30 ,40));
		this.equipment =  new Bow(equipment);
		this.equipment = new Shield(equipment);
	}
}

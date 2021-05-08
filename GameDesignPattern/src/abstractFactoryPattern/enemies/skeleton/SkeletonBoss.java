package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class SkeletonBoss extends Enemy{
	
	public SkeletonBoss() {
		super("Skeleton Boss");
		this.equipment = new RegularItem(equipment, "Skeleton Boss",new Stats(150, 150, 30, 20 , 10));
		this.equipment =  new Bow(equipment);
		this.equipment = new DemonSpear(this.equipment);	
	}
}

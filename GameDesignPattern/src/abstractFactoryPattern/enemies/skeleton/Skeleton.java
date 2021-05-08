package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public abstract class Skeleton extends Enemy{
	protected final Stats skeletonBaseStats = new Stats(60, 60, 40, 10 ,1);
	
	public Skeleton(String name) {
		super(name);
		this.equipment =  new Bow(equipment);
		this.equipment = new Shield(equipment);
	}
}

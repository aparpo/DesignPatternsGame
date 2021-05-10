package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class SkeletonBoss extends Skeleton{
	
	public SkeletonBoss() {
		super("Skeletor");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(skeletonBaseStats, World.BOSS));
		this.behaviour = new AgressiveStrategy();
		this.equipment = new VampiricSword(this.equipment);	
	}
}

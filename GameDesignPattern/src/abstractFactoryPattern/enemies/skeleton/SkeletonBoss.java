package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.behaviours.*;

public class SkeletonBoss extends Skeleton{
	
	public SkeletonBoss() {
		super("Skeletor");
		this.equipment = new BaseEquipment(this.equipment, "Base Equipment", levelStats(skeletonBaseStats, World.BOSS));
		this.behaviour = new AgressiveBehaviour();
		this.equipment = new VampiricSword(this.equipment);	
	}
}

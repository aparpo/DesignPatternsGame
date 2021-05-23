package com.utad.project.abstractFactoryPattern.enemies.skeleton;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class SkeletonWorld3 extends Skeleton{

	public SkeletonWorld3(int id) {
		super("Wheel Skull"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(skeletonBaseStats, World.WORLD2));
	}
}

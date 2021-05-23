package com.utad.project.abstractFactoryPattern.enemies.skeleton;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class SkeletonWorld2 extends Skeleton{

	public SkeletonWorld2(int id) {
		super("Skeleton"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(skeletonBaseStats, World.WORLD2));
	}
}

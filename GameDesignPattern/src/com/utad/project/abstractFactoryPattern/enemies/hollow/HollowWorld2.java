package com.utad.project.abstractFactoryPattern.enemies.hollow;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class HollowWorld2 extends Hollow{

	public HollowWorld2(int id) {
		super("Hollow Knight"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD2));
	}
}

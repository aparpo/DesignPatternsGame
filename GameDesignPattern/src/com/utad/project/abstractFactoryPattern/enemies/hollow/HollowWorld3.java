package com.utad.project.abstractFactoryPattern.enemies.hollow;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class HollowWorld3 extends Hollow{
	
	public HollowWorld3(int id) {
		super("Scared Hollow"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD3));	
	}
}

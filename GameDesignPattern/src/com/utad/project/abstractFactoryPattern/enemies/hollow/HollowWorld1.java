package com.utad.project.abstractFactoryPattern.enemies.hollow;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class HollowWorld1 extends Hollow{

	public HollowWorld1(int id) {
		super("Hollow"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD1));
		addItem(new Bow());
	}
	
}

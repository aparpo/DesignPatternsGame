package com.utad.project.abstractFactoryPattern.enemies.giant;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class GiantWorld4 extends Giant{

	public GiantWorld4(int id) {
		super("Giant"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(giantBaseStats, World.WORLD4));
	}
}

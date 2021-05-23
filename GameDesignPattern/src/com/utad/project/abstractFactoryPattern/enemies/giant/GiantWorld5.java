package com.utad.project.abstractFactoryPattern.enemies.giant;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class GiantWorld5 extends Giant{

	public GiantWorld5(int id) {
		super("Royal Giant"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(giantBaseStats, World.WORLD5));
	}
}

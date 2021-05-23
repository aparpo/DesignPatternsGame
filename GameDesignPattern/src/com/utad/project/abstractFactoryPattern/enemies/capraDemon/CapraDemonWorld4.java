package com.utad.project.abstractFactoryPattern.enemies.capraDemon;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class CapraDemonWorld4 extends CapraDemon{

	public CapraDemonWorld4(int id) {
		super("Capra Demon"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(capraDemonBaseStats, World.WORLD4));	
	}
}

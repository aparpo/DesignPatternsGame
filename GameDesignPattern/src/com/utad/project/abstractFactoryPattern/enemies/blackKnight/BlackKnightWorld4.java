package com.utad.project.abstractFactoryPattern.enemies.blackKnight;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class BlackKnightWorld4 extends BlackKnight{
	
	public BlackKnightWorld4(int id) {
		super("Axe Knight"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(blackKnightBaseStats, World.WORLD4));	
	}
}

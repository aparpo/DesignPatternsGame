package com.utad.project.abstractFactoryPattern.enemies.blackKnight;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class BlackKnightWorld1 extends BlackKnight{
	
	public BlackKnightWorld1(int id) {
		super("Knight"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(blackKnightBaseStats, World.WORLD1));			
	}
}

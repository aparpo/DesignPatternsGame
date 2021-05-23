package com.utad.project.abstractFactoryPattern.enemies.crystal;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class CrystalWorld1 extends Crystal{
	
	public CrystalWorld1(int id) {
		super("Crystal"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(crystalBaseStats, World.WORLD1));
	
	}
}

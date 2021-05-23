package com.utad.project.abstractFactoryPattern.enemies.bosses;
import com.utad.project.base.Stats;
import com.utad.project.decoratorPattern.RegularItem;
import com.utad.project.decoratorPattern.items.bossWeapons.ArtoriasSword;
import com.utad.project.strategyPattern.normalStrategies.AgressiveStrategy;

public class Sif extends Boss{
			
	public Sif() {
		super("Great Grey Wolf Sif");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(120,120,30,20,3));	
		this.addItem(new ArtoriasSword());
		this.behaviour = new AgressiveStrategy();
	}
}

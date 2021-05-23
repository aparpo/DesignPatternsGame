package com.utad.project.abstractFactoryPattern.enemies.blackKnight;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;

public class BlackKnightWorld4 extends BlackKnight{
	
	public BlackKnightWorld4(int id) {
		super("Axe Knight Nº"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(blackKnightBaseStats, World.WORLD4));	
	}
}

package com.utad.project.abstractFactoryPattern.enemies.giant;
import com.utad.project.abstractFactoryPattern.*;
import com.utad.project.decoratorPattern.*;

public class GiantWorld5 extends Giant{

	public GiantWorld5(int id) {
		super("Royal Giant Nº"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(giantBaseStats, World.WORLD5));
	}
}

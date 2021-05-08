package abstractFactoryPattern.enemies.hollow;

import base.Enemy;
import base.Stats;
import decoratorPattern.RegularItem;
import decoratorPattern.items.*;

public class HollowBoss extends Enemy{
	public HollowBoss() {
		super("Archy Hollow ");
		this.equipment = new RegularItem(equipment, "Archy Hollow",new Stats(120, 150, 45, 25 ,15));
		this.equipment = new VampiricSword(this.equipment);	
		this.equipment = new SolarAegis(equipment);
	}
}

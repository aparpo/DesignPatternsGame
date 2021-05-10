package abstractFactoryPattern.enemies.hollow;

import abstractFactoryPattern.World;
import base.Enemy;
import base.Stats;
import decoratorPattern.RegularItem;
import decoratorPattern.items.*;

public class HollowBoss extends Hollow{
	public HollowBoss() {
		super("Archy Hollow ");
		this.equipment = new RegularItem(equipment, "Archy Hollow",levelStats(hollowBaseStats, World.BOSS));
		this.equipment = new VampiricSword(this.equipment);	
		this.equipment = new SolarAegis(equipment);
	}
}

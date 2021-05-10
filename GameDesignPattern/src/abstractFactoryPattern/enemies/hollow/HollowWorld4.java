package abstractFactoryPattern.enemies.hollow;

import abstractFactoryPattern.World;
import decoratorPattern.RegularItem;

public class HollowWorld4 extends Hollow{
	public HollowWorld4() {
		super("Demon Hollow");
		this.equipment = new RegularItem(equipment, "Demon Hollow",levelStats(hollowBaseStats, World.WORLD2));
	}
}


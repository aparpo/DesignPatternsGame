package abstractFactoryPattern.enemies.hollow;

import abstractFactoryPattern.World;
import decoratorPattern.RegularItem;

public class HollowWorld5 extends Hollow{
	public HollowWorld5() {
		super("Demon Hollow");
		this.equipment = new RegularItem(equipment, "Demon Hollow",levelStats(hollowBaseStats, World.WORLD2));
	}
}

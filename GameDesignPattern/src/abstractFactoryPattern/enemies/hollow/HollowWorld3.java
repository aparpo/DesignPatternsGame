package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.World;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class HollowWorld3 extends Hollow{
	public HollowWorld3() {
		super("Demon Hollow");
		this.equipment = new RegularItem(equipment, "Demon Hollow",levelStats(hollowBaseStats, World.WORLD2));
	}
}

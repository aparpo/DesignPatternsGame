package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.World;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class HollowWorld1 extends Hollow{

	public HollowWorld1() {
		super("Hollow fighter");
		equipment = new RegularItem(equipment, "custom",levelStats(hollowBaseStats, World.WORLD1));
	}
}

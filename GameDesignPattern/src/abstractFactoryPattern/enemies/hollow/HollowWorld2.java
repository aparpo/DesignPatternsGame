package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class HollowWorld2 extends Hollow{

	public HollowWorld2() {
		super("Hollow Knight");
		this.equipment = new RegularItem(equipment, "custom",levelStats(hollowBaseStats, World.WORLD2));		
	}
}

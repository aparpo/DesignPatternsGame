package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class HollowWorld2 extends Hollow{

	public HollowWorld2() {
		super("Hollow Knight");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD2));
	}
}

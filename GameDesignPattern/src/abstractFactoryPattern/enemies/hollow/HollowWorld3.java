package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class HollowWorld3 extends Hollow{
	
	public HollowWorld3() {
		super("Scared Hollow");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD3));
		this.behaviour = new AgressiveStrategy();
		this.equipment = new Shield(this.equipment);
	}
}

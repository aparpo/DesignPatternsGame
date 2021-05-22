package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class HollowWorld1 extends Hollow{

	public HollowWorld1(int id) {
		super("Hollow"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD1));
		addItem(new Bow());
	}
	
}

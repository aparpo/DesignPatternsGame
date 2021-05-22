package abstractFactoryPattern.enemies.giant;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class GiantWorld4 extends Giant{

	public GiantWorld4(int id) {
		super("Giant"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(giantBaseStats, World.WORLD4));
	}
}

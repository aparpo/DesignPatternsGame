package abstractFactoryPattern.enemies.giant;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class GiantWorld5 extends Giant{

	public GiantWorld5(int id) {
		super("Royal Giant"+id);
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(giantBaseStats, World.WORLD5));
	}
}

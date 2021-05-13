package abstractFactoryPattern.enemies.giant;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class GiantWorld4 extends Giant{

	public GiantWorld4() {
		super("Great Stone Knight");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(giantBaseStats, World.WORLD4));
		this.behaviour = new AgressiveStrategy();
		this.equipment = new Bow(this.equipment);	
		this.equipment = new Shield(this.equipment);	
	}
}

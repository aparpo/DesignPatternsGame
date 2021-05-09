package abstractFactoryPattern.enemies.giant;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.behaviours.*;

public class GiantWorld5 extends Giant{

	public GiantWorld5() {
		super("Royal Sentinel");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(giantBaseStats, World.WORLD5));
		this.behaviour = new BalancedBehaviour();
		this.equipment = new Bow(this.equipment);	
	}
}

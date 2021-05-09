package abstractFactoryPattern.enemies.capraDemon;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.behaviours.*;

public class CapraDemonWorld4 extends CapraDemon{

	public CapraDemonWorld4() {
		super("Dark Capra Demon");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(capraDemonBaseStats, World.WORLD4));
		this.behaviour = new BalancedBehaviour();
		this.equipment = new Bow(this.equipment);	
	}
}

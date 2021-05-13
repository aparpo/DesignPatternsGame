package abstractFactoryPattern.enemies.capraDemon;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class CapraDemonWorld4 extends CapraDemon{

	public CapraDemonWorld4() {
		super("Dark Capra Demon");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(capraDemonBaseStats, World.WORLD4));	
	}
}

package abstractFactoryPattern.enemies.capraDemon;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class CapraDemonBoss extends CapraDemon{

	public CapraDemonBoss() {
		super("Vermillion Capra Demon");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(capraDemonBaseStats, World.BOSS));
		
	}
}

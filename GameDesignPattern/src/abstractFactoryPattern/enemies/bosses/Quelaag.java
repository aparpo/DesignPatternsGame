package abstractFactoryPattern.enemies.bosses;
import base.Stats;
import decoratorPattern.RegularItem;
import strategyPattern.normalStrategies.DefensiveStrategy;

public class Quelaag extends Boss{
	
	public Quelaag() {
		super("Chaos Witch Quelaag");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(0,0,0,0,0));	
		this.behaviour = new DefensiveStrategy();
	}
}

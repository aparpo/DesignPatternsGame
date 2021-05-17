package abstractFactoryPattern.enemies.bosses;
import base.Stats;
import decoratorPattern.RegularItem;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class OrsteinAndSmough extends Boss{
	
	public OrsteinAndSmough() {
		super("Orstein & Smough");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(0,0,0,0,0));	
		this.behaviour = new AgressiveStrategy();
	}
}

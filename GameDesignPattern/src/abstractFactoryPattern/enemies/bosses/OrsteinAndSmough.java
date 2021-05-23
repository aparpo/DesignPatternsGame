package abstractFactoryPattern.enemies.bosses;
import base.Stats;
import decoratorPattern.RegularItem;
import decoratorPattern.items.bossWeapons.SunlightSpear;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class OrsteinAndSmough extends Boss{
	
	public OrsteinAndSmough() {
		super("Orstein & Smough");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(140,140,35,35,2));	
		this.addItem(new SunlightSpear()); 
		this.behaviour = new AgressiveStrategy();
	}
}

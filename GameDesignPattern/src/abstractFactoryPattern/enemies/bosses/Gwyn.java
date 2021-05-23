package abstractFactoryPattern.enemies.bosses;
import base.Stats;
import decoratorPattern.RegularItem;
import decoratorPattern.items.bossWeapons.SunlightSpear;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class Gwyn extends Boss{
	
	public Gwyn() {
		super("Gwyn Lord of Cinder");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(200,200,70,60,3));	
		this.addItem(new SunlightSpear()); 
		this.behaviour = new AgressiveStrategy();
	}
}

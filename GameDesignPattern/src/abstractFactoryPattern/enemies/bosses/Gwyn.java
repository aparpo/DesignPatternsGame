package abstractFactoryPattern.enemies.bosses;
import base.Stats;
import decoratorPattern.RegularItem;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class Gwyn extends Boss{
	
	public Gwyn() {
		super("Gwyn Lord of Cinder");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(0,0,0,0,0));	
		this.behaviour = new AgressiveStrategy();
	}
}

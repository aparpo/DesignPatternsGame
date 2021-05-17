package abstractFactoryPattern.enemies.bosses;
import base.Stats;
import decoratorPattern.RegularItem;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class Sif extends Boss{
			
			public Sif() {
				super("Great Grey Wolf Sif");
				this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(0,0,0,0,0));	
				this.behaviour = new AgressiveStrategy();
			}
}

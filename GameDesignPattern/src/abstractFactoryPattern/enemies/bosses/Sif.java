package abstractFactoryPattern.enemies.bosses;
import base.Stats;
import decoratorPattern.RegularItem;
import decoratorPattern.items.bossWeapons.ArtoriasSword;
import strategyPattern.normalStrategies.AgressiveStrategy;

public class Sif extends Boss{
			
	public Sif() {
		super("Great Grey Wolf Sif");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", new Stats(120,120,30,20,3));	
		this.addItem(new ArtoriasSword());
		this.behaviour = new AgressiveStrategy();
	}
}

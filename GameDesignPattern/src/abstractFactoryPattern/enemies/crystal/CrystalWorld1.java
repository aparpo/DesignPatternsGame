package abstractFactoryPattern.enemies.crystal;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class CrystalWorld1 extends Crystal{
	
	public CrystalWorld1() {
		super("Undead Crystal Soldier");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(crystalBaseStats, World.WORLD1));
		
	}
}

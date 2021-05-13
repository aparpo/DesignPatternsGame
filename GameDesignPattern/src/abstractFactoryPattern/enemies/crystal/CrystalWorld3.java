package abstractFactoryPattern.enemies.crystal;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class CrystalWorld3 extends Crystal{

	public CrystalWorld3() {
		super("Crystal Knight");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(crystalBaseStats, World.WORLD3));
		this.behaviour = new AgressiveStrategy();
		this.equipment = new Bow(this.equipment);	
		this.equipment = new Shield(this.equipment);
	}
}

package abstractFactoryPattern.enemies.mage;

import base.Enemy;
import base.Stats;
import decoratorPattern.items.MagicCoat;
import decoratorPattern.items.Staff;

public class Mage extends Enemy{
	protected final Stats MageBaseStats = new Stats(60, 60, 40, 10 ,1);
	
	public Mage(String name) {
		super(name);
		this.equipment =  new Staff(equipment);
		this.equipment = new MagicCoat(equipment);
	}
}

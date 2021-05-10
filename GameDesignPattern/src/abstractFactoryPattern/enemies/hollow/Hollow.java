package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.LongSword;
import decoratorPattern.items.Shield;

public class Hollow extends Enemy{
	protected final Stats hollowBaseStats = new Stats(70, 70, 30, 20 ,2);
	
	public Hollow(String name) {
		super(name);
		equipment = new LongSword(equipment);	
		equipment = new Shield(equipment);
	}
}

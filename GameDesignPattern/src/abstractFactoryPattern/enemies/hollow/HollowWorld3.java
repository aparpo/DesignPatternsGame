package abstractFactoryPattern.enemies.hollow;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class HollowWorld3 extends Enemy{
	public HollowWorld3() {
		super("Demon Hollow");
		this.equipment = new RegularItem(equipment, "Demon Hollow",new Stats(30, 30, 20, 10 ,7));
		this.equipment = new LongSword(this.equipment);	
		this.equipment = new Shield(equipment);
	}
}

package abstractFactoryPattern.enemies.hollow;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class HollowWorld1 extends Enemy{

	public HollowWorld1() {
		super("Hollow fighter");
		this.equipment = new RegularItem(equipment, "custom",new Stats(300, 200, 80, 30 ,40));
		this.equipment = new LongSword(this.equipment);	
		this.equipment = new Shield(equipment);
	}
}

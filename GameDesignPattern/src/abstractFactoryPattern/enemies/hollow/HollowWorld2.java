package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public class HollowWorld2 extends Hollow{

	public HollowWorld2() {
		super("Hollow Knight");
		this.equipment = new RegularItem(equipment, "custom",new Stats(300, 200, 80, 30 ,40));
		this.equipment = new LongSword(this.equipment);	
		this.equipment = new Shield(equipment);
		//this.setBehaviour(new AgressiveBehaviour());
		
	}
}

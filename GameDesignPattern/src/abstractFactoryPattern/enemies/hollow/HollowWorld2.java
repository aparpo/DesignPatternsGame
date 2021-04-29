package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.behaviours.*;

public class HollowWorld2 extends Hollow{

	public HollowWorld2() {
		super("Hollow Knight");
		this.equipment = new BaseEquipment(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD2));
		this.behaviour = new AgressiveBehaviour();
		this.equipment = new LongSword(this.equipment);	
	}
}

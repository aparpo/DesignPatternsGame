package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.behaviours.*;

public class HollowWorld1 extends Hollow{

	public HollowWorld1() {
		super("Hollow Archer");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(hollowBaseStats, World.WORLD1));
		this.behaviour = new BalancedBehaviour();
		this.equipment = new Bow(this.equipment);	
	}
}

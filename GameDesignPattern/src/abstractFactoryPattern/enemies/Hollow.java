package abstractFactoryPattern.enemies;
import abstractFactoryPattern.*;
import decoratorPattern.*;

public class Hollow extends Enemy{
	protected final Stats hollowBaseStats = new Stats(250, 250, 50, 50 ,25);
	
	public Hollow(World level) {
		super("Hollow");
		this.equipment = new BaseEquipment(this.equipment, "Base Equipment", levelStats(hollowBaseStats, level));	
	}
	
}

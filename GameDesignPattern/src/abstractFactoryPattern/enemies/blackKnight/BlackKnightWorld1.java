package abstractFactoryPattern.enemies.blackKnight;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class BlackKnightWorld1 extends BlackKnight{
	
	public BlackKnightWorld1() {
		super("Halberd Knight");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(blackKnightBaseStats, World.WORLD1));			
	}
}

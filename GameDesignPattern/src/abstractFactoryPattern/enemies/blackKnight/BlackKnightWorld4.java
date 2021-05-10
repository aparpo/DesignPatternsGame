package abstractFactoryPattern.enemies.blackKnight;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class BlackKnightWorld4 extends BlackKnight{
	
	public BlackKnightWorld4() {
		super("Axe Knight");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(blackKnightBaseStats, World.WORLD4));
		this.behaviour = new AgressiveStrategy();
		this.equipment = new Bow(this.equipment);	
	}
}

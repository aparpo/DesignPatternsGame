package abstractFactoryPattern.enemies.blackKnight;
import abstractFactoryPattern.*;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

public class BlackKnightWorld5 extends BlackKnight{
	
	public BlackKnightWorld5() {
		super("Great Sword Knight");
		this.equipment = new RegularItem(this.equipment, "Base Equipment", levelStats(blackKnightBaseStats, World.WORLD5));
		this.behaviour = new AgressiveStrategy();
		this.equipment = new Bow(this.equipment);	
	}
}

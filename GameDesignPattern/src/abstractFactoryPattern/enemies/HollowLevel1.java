package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Level;
import decoratorPattern.Stats;
import decoratorPattern.items.Shield;

public class HollowLevel1 extends Hollow{
	static Stats hollowLevel1Stats = levelStats(hollowStats, Level.LEVEL1);
	
	public HollowLevel1() {
		super("Hollow", hollowLevel1Stats , new Shield(hollowLevel1Stats), "Hollow Warrior");
	}
}

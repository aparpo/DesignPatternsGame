package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Level;
import decoratorPattern.Stats;
import decoratorPattern.items.Bow;

public class HollowLevel2 extends Hollow{
	static Stats hollowLevel2Stats = levelStats(hollowStats, Level.LEVEL2);
	
	public HollowLevel2() {
		super("Hollow", hollowLevel2Stats , new Bow(hollowLevel2Stats), "Undead Knight Archer");
	}
}

package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Level;
import decoratorPattern.Stats;
import decoratorPattern.items.LongSword;

public class HollowLevel3 extends Hollow{
static Stats hollowLevel3Stats = levelStats(hollowStats, Level.LEVEL3);
	
	public HollowLevel3() {
		super("Hollow", hollowLevel3Stats , new LongSword(hollowLevel3Stats), "Balder Knight");
	}
}

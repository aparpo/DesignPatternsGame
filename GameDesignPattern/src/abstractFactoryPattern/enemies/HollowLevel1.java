package abstractFactoryPattern.enemies;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;


public class HollowLevel1 extends Hollow{

	public HollowLevel1(String name, Stats stats, ActiveItemDecorator weapon, String hollowType) {
		super(name, stats, weapon, hollowType);
	}
	
	
}

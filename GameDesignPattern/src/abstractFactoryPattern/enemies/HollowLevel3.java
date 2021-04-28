package abstractFactoryPattern.enemies;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class HollowLevel3 extends Hollow{

	public HollowLevel3(String name, Stats stats, ActiveItemDecorator weapon, String hollowType) {
		super(name, stats, weapon, hollowType);
		
	}

}

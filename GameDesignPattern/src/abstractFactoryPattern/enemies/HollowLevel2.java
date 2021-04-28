package abstractFactoryPattern.enemies;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class HollowLevel2 extends Hollow{

	public HollowLevel2(String name, Stats stats, ActiveItemDecorator weapon, String hollowType) {
		super(name, stats, weapon, hollowType);

	}

}

package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Enemy;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class Hollow extends Enemy{
	protected String hollowType;
		
	public Hollow(String name, Stats stats, ActiveItemDecorator weapon, String hollowType) {
		super(name, stats, weapon);
		this.hollowType = hollowType;
	}

	public String getHollowType() {
		return hollowType;
	}

	public void setHollowType(String hollowType) {
		this.hollowType = hollowType;
	}
	
}

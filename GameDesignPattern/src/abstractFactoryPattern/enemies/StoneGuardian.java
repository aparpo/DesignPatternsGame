package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Enemy;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class StoneGuardian extends Enemy{
	protected String size;

	public StoneGuardian(String name, Stats stats, ActiveItemDecorator weapon, String size) {
		super(name, stats, weapon);
		this.size = size;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}

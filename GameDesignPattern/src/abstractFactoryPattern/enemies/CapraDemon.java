package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Enemy;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class CapraDemon extends Enemy{
	protected String color;

	public CapraDemon(String name, Stats stats, ActiveItemDecorator weapon, String color) {
		super(name, stats, weapon);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}

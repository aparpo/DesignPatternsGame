package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Enemy;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class Hollow extends Enemy{
	protected String hollowType;
	protected static Stats hollowStats = new Stats(250, 250, 50, 50, 10);
		
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
	
	public String toString() {
		return "Enemy: " + name + " - Weapon: " +  weapon.getName() + " - Hollow Type: " + hollowType + " - Stats: " + stats.toString();
	}
	
	public static void main(String[] args) {
		Enemy hollow = new HollowLevel3();
		
		System.out.print(hollow.toString());
	}
}

package abstractFactoryPattern;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class Enemy {
	protected String name;
	protected Stats stats;
	protected ActiveItemDecorator weapon;
		
	public Enemy(String name, Stats stats, ActiveItemDecorator weapon) {
		this.name = name;
		this.stats = stats;
		this.weapon = weapon;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Stats getStats() {
		return stats;
	}
	
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	public ActiveItemDecorator getWeapon() {
		return weapon;
	}
	
	public void setWeapon(ActiveItemDecorator weapon) {
		this.weapon = weapon;
	}	
}

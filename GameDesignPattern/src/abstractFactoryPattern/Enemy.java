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
	
	public static Stats levelStats(Stats stats, Level level) {
		stats.setLife(stats.getLife() * level.getComplexFactor());
		stats.setMaxLife(stats.getMaxLife() * level.getComplexFactor());
		stats.setAttack(stats.getAttack() * level.getComplexFactor());
		stats.setDefense(stats.getDefense() * level.getComplexFactor());
		stats.setSpeed(stats.getSpeed() * level.getComplexFactor());
		
		return stats;
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

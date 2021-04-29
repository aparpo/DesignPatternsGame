package abstractFactoryPattern;
import decoratorPattern.*;
import base.Character;

public class Enemy extends Character{

	public Enemy(String name) {
		super(name);
	}

	public void decision() {
		
	}

	public Stats levelStats(Stats stats, World level) {
		Stats modifiedStats = new Stats();
		
		modifiedStats.setMaxLife(stats.getMaxLife() * level.getComplexFactor());
		modifiedStats.setLife(stats.getLife() * level.getComplexFactor());
		modifiedStats.setAttack(stats.getAttack() * level.getComplexFactor());
		modifiedStats.setDefense(stats.getDefense() * level.getComplexFactor());
		modifiedStats.setSpeed(stats.getSpeed() * level.getComplexFactor());
		
		return modifiedStats;
	}
}

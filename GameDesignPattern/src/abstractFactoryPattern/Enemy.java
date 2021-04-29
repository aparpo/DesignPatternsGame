package abstractFactoryPattern;
import decoratorPattern.*;
import strategyPattern.*;
import base.Character;

public class Enemy extends Character{
	protected BehaviourStrategy behaviour;
	
	public Enemy(String name) {
		super(name);
	}

	public void decision() {
		
	}

	public Stats levelStats(Stats stats, World world) {
		Stats modifiedStats = new Stats();
		
		modifiedStats.setMaxLife(stats.getMaxLife() * world.getComplexFactor());
		modifiedStats.setLife(stats.getLife() * world.getComplexFactor());
		modifiedStats.setAttack(stats.getAttack() * world.getComplexFactor());
		modifiedStats.setDefense(stats.getDefense() * world.getComplexFactor());
		modifiedStats.setSpeed(stats.getSpeed() * world.getComplexFactor());
		
		return modifiedStats;
	}
}

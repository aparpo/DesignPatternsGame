package base;
import abstractFactoryPattern.World;
import decoratorPattern.*;
import singletonPattern.GameManager;
import strategyPattern.*;

public class Enemy extends Character{
	
	private DecisionTemplate behaviour;
	public Enemy(String name) {
		super(name);
	}

	public void decision() {
		behaviour.decision(this, GameManager.getManager().getPlayer());
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

	public DecisionTemplate getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(DecisionTemplate behaviour) {
		this.behaviour = behaviour;
	}
}

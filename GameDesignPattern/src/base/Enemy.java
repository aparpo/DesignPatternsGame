package base;
import abstractFactoryPattern.World;
import decoratorPattern.*;
import singletonPattern.GameManager;
import strategyPattern.*;

public class Enemy extends Character{
	
	protected DecisionTemplate behaviour;
	protected String enemyName;
	
	public Enemy(String name) {
		super(name);
	}

	public void decision() {
		behaviour.decision(this, GameManager.getManager().getPlayer());
	}

	public Stats levelStats(Stats stats, World world) {
		Stats modifiedStats = new Stats();
		
		modifiedStats.setMaxLife((int)(stats.getMaxLife() * world.getComplexFactor()));
		modifiedStats.setLife((int)(stats.getLife() * world.getComplexFactor()));
		modifiedStats.setAttack((int)(stats.getAttack() * world.getComplexFactor()));
		modifiedStats.setDefense((int)(stats.getDefense() * world.getComplexFactor()));
		modifiedStats.setSpeed((int)(stats.getSpeed() * world.getComplexFactor()));
		
		return modifiedStats;
	}

	public DecisionTemplate getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(DecisionTemplate behaviour) {
		this.behaviour = behaviour;
	}
	
	public String toString() {
		return this.enemyName + " [Enemy Type: " + this.name + ", Weapon: " + this.equipment.getName() + ", Behaviour: " + this.behaviour + 
				", Stats: (Life: " + this.equipment.getLife() + ", Att: " + this.equipment.getAttack() + ", Def: " + this.equipment.getDefense() + ", Speed: " + this.equipment.getSpeed() + ")]";
	}
}

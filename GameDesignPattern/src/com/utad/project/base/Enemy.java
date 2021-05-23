package com.utad.project.base;
import com.utad.project.abstractFactoryPattern.World;
import com.utad.project.decoratorPattern.*;
import com.utad.project.singletonPattern.GameManager;
import com.utad.project.strategyPattern.*;
import com.utad.project.strategyPattern.normalStrategies.*;

public class Enemy extends Character{
	
	protected DecisionTemplate behaviour;
	
	public Enemy(String name, String sprite) {
		super(name,sprite);
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
	
	public void changeStrategy() {
		if(this.getEquipment().getLife() < this.getEquipment().getMaxLife()*0.25) {
			this.setBehaviour(new DefensiveStrategy());
		}else {
			int random = (int)(Math.random()*10);
			if(random < 2) {
				random = (int)(Math.random()*3);
				if(random == 1) {
					if(!(this.getBehaviour() instanceof DefensiveStrategy)) {
						this.setBehaviour(new DefensiveStrategy());
					}
				}else if(random == 2) {
					if(!(this.getBehaviour() instanceof AgressiveStrategy)) {
						this.setBehaviour(new AgressiveStrategy());
					}
				}else if(random == 3) {
					if(!(this.getBehaviour() instanceof DumbStrategy)) {
						this.setBehaviour(new DumbStrategy());
					}
				}
			}
		}
	}
	
	public DecisionTemplate getBehaviour() {
		return behaviour;
	}
	
	public void setBehaviour(DecisionTemplate behaviour) {
		this.behaviour = behaviour;
	}
}

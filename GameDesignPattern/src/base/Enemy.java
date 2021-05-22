package base;
import abstractFactoryPattern.World;
import decoratorPattern.*;
import singletonPattern.GameManager;
import strategyPattern.*;
import strategyPattern.normalStrategies.*;

public class Enemy extends Character{
	
	protected DecisionTemplate behaviour;
	
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
	
	public void changeStrategy() {
		if(this.getEquipment().getLife() < this.getEquipment().getMaxLife()*0.25) {
			this.setBehaviour(new DefensiveStrategy());
			System.out.println("La estrategia del enemigo a pasado a ser defensiva");
		}else {
			int random = (int)(Math.random()*10);
			if(random < 2) {
				random = (int)(Math.random()*3);
				if(random == 1) {
					if(!(this.getBehaviour() instanceof DefensiveStrategy)) {
						this.setBehaviour(new DefensiveStrategy());
						System.out.println("La estrategia del enemigo a pasado a ser defensiva");
					}
				}else if(random == 2) {
					if(!(this.getBehaviour() instanceof AgressiveStrategy)) {
						this.setBehaviour(new AgressiveStrategy());
						System.out.println("La estrategia del enemigo a pasado a ser agresiva");
					}
				}else if(random == 3) {
					if(!(this.getBehaviour() instanceof DumbStrategy)) {
						this.setBehaviour(new DumbStrategy());
						System.out.println("La estrategia del enemigo a pasado a ser aleatoria");
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

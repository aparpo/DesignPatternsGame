package com.utad.project.abstractFactoryPattern.enemyFactories;
import com.utad.project.abstractFactoryPattern.FactoryTemplate;
import com.utad.project.abstractFactoryPattern.enemies.blackKnight.*;
import com.utad.project.abstractFactoryPattern.enemies.bosses.Boss;
import com.utad.project.abstractFactoryPattern.enemies.bosses.Nito;
import com.utad.project.abstractFactoryPattern.enemies.capraDemon.*;
import com.utad.project.abstractFactoryPattern.enemies.giant.*;
import com.utad.project.base.Enemy;
import com.utad.project.base.Stats;
import com.utad.project.decoratorPattern.Item;
import com.utad.project.decoratorPattern.ItemDecorator;
import com.utad.project.decoratorPattern.RegularItem;
import com.utad.project.decoratorPattern.items.*;
import com.utad.project.statePattern.States;
import com.utad.project.strategyPattern.normalStrategies.AgressiveStrategy;
import com.utad.project.strategyPattern.normalStrategies.DefensiveStrategy;

public class LevelFactoryWorld4 extends FactoryTemplate{
	//Furios world
	int demonCount =0;
	int giantCount = 0;
	int knightCount = 0;
	int itemCount = 0;

	public LevelFactoryWorld4() {
		super();
	}

	//Genera el Boss final correspondiente al nivel en el que nos encontremos
	public Boss generateBoss() {
		return new Nito();
	}

	//Genera un enemigo.
	protected Enemy createEnemy() {
		int randNum = rand.nextInt(100);
		if(randNum < 40) {
			return createCapraDemon();
		}
		else if(randNum >= 40 && randNum < 70 || giantCount > 0) {
			return createBlackKnight();
		}
		else {
			return createGiant();
		}
	}

	//Selecciona un arma para el enemigo generado.
	protected void decorateEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);

		if(randNum < 80) {
			enemy.addItem(new DemonSpear());
		}else {
			enemy.addItem(new Thornmail());
		}
	}

	//Selecciona un comportamiento para el enemigo generado.
	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);
		if(randNum < 80) {
			enemy.getState().setSuggestion(States.FURIOUS);
			enemy.setBehaviour(new AgressiveStrategy());
		}else {
			enemy.getState().setSuggestion(States.CONFUSED);
			enemy.setBehaviour(new DefensiveStrategy());
		}
		
	}

	public Enemy createCapraDemon() {
		demonCount++;
		return new CapraDemonWorld4(demonCount);
	}
	
	public Enemy createGiant() {
		giantCount++;
		return new GiantWorld4(giantCount);
	}
	
	public Enemy createBlackKnight() {
		knightCount++;
		return new BlackKnightWorld4(knightCount);
	}
	
	public ItemDecorator generateItem() {
		//Genera items (de tres en tres) pertenencientes a una clase concreta
		int randNum = rand.nextInt(100);
		itemCount++;
		if(itemCount%3==0) { //Regulares
			//Estadisticas desequilibradas
			Stats stats = new Stats(0,rand.nextInt(30),rand.nextInt(60),rand.nextInt(30),rand.nextInt(3));
			return new RegularItem("Bloody axe",stats);
		}else if (itemCount%3 == 1) { //Con Activa
			if(randNum < 40) {
				return new Thornmail();
			}else {
				return new ElectricShield();
			}
		}else { //Con Pasiva
			if(randNum < 70) {
				return new Antidote();
			}else {
				return new Bow();
			}

		}
		
	}

}

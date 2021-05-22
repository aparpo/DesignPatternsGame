package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import decoratorPattern.ItemDecorator;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.AgressiveStrategy;
import strategyPattern.normalStrategies.DefensiveStrategy;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Nito;
import abstractFactoryPattern.enemies.giant.*;
import abstractFactoryPattern.enemies.capraDemon.*;

public class LevelFactoryWorld4 extends FactoryTemplate{
	
	int demonCount =0;
	int giantCount = 0;
	int knightCount = 0;
		
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
		else if(randNum >= 40 && randNum < 70) {
			return createBlackKnight();
		}
		else {
			return createGiant();
		}
	}

	//Selecciona un arma para el enemigo generado.
	protected void decorateEnemy(Enemy enemy) {
		//Mejorar al enemigo con habilidades del mundo 1
		//Aqui se pueden cambiar estadisticas o habilidades segun el mundo 
		//Se crean enemigos acordes al nivel de dificultad pero los Hollow del mundo 1 no son siempre exactamente iguales p.e.
		int randNum = rand.nextInt(100);
		enemy.getEquipment().addItem(new Potion(2));
		randNum = rand.nextInt(100);
		if(randNum < 30) {
			enemy.addItem(new Thornmail());
		}
		else if (randNum >= 30 && randNum < 60) {
			enemy.addItem(new ElectricShield());
		}
		else {
			enemy.addItem(new VampiricSword());
		}
	}

	//Selecciona un comportamiento para el enemigo generado.
	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);

		if (randNum < 50) {
			enemy.setBehaviour(new AgressiveStrategy());
		}
		else {
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
	
	@Override
	public ItemDecorator generateItem() {
		// TODO Auto-generated method stub
		return null;
	}
}

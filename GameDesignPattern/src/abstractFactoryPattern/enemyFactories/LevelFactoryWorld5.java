package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.AgressiveStrategy;
import strategyPattern.normalStrategies.DefensiveStrategy;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Gwyn;
import abstractFactoryPattern.enemies.giant.*;

public class LevelFactoryWorld5 extends FactoryTemplate{
	
	public LevelFactoryWorld5() {
		super();
	}
	
	public Boss generateBoss() {
		//Genera el Boss final correspondiente al nivel en el que nos encontremos
		return new Gwyn();
	}
	
	protected Enemy createEnemy() {
		int randNum = rand.nextInt(100);
		
		if(randNum < 55) {
			return createGiant();
		}
		else {
			return createBlackKnight();
		}
	}

	protected void decorateEnemy(Enemy enemy) {
		//Mejorar al enemigo con habilidades del mundo 1
		//Aqui se pueden cambiar estadisticas o habilidades segun el mundo 
		//Se crean enemigos acordes al nivel de dificultad pero los Hollow del mundo 1 no son siempre exactamente iguales p.e.
		int randNum = rand.nextInt(100);
		enemy.getEquipment().addItem(new Potion(3));
		randNum = rand.nextInt(100);
		if(randNum < 30) {
			enemy.addItem(new DemonSpear());
		}
		else if (randNum >= 30 && randNum < 60) {
			enemy.addItem(new RatCrossbow());
		}
		else {
			enemy.addItem(new SolarAegis());
		}
	}

	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);

		if (randNum < 65) {
			enemy.setBehaviour(new AgressiveStrategy());
		}
		else {
			enemy.setBehaviour(new DefensiveStrategy());
		}
	}
	
	
	private Enemy createGiant() {
		return new GiantWorld4();
	}
	
	private Enemy createBlackKnight() {
		return new BlackKnightWorld4();
	}

	public Item generateItem() {
		// TODO Auto-generated method stub
		return null;
	}

}

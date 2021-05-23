package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import base.Stats;
import decoratorPattern.Item;
import decoratorPattern.ItemDecorator;
import decoratorPattern.RegularItem;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.AgressiveStrategy;
import strategyPattern.normalStrategies.DefensiveStrategy;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Gwyn;
import abstractFactoryPattern.enemies.giant.*;

public class LevelFactoryWorld5 extends FactoryTemplate{
	
	int giantCount = 0;
	int knightCount = 0;
	private int itemCount;
	
	public LevelFactoryWorld5() {
		super();
	}
	
	//Genera el Boss final correspondiente al nivel en el que nos encontremos
	public Boss generateBoss() {
		return new Gwyn();
	}
	
	//Genera un enemigo.
	protected Enemy createEnemy() {
		int randNum = rand.nextInt(100);
		if(randNum < 55) {
			return createGiant();
		}
		else {
			return createBlackKnight();
		}
	}

	//Selecciona un arma para el enemigo generado.
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

	//Selecciona un comportamiento para el enemigo generado.
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
		giantCount++;
		return new GiantWorld4(giantCount);
	}
	
	private Enemy createBlackKnight() {
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
				return new RatCrossbow();
			}
		}else { //Con Pasiva
			return new DemonSpear();

		}
		
	}

}

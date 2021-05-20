package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.AgressiveStrategy;
import strategyPattern.normalStrategies.DumbStrategy;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.skeleton.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Sif;
import abstractFactoryPattern.enemies.hollow.*;

//Mundo basado en el estado envenenado
public class LevelFactoryWorld2 extends FactoryTemplate{ 
	
	public LevelFactoryWorld2() {
		super();
	}
	
	//Genera el Boss final correspondiente al nivel en el que nos encontremos
	public Boss generateBoss() {
		return new Sif();
	}

	//Genera un enemigo.
	protected Enemy createEnemy() {
		int randNum = rand.nextInt(100);
		if(randNum < 65) {
			return createSkeleton();
		}
		else {
			return createHollow();
		}
	}

	//Selecciona un arma para el enemigo generado.
	protected void decorateEnemy(Enemy enemy) {
		//Mejorar al enemigo con habilidades del mundo 1
		//Aqui se pueden cambiar estadisticas o habilidades segun el mundo 
		//Se crean enemigos acordes al nivel de dificultad pero los Hollow del mundo 1 no son siempre exactamente iguales p.e.
		int randNum = rand.nextInt(100);
		enemy.getEquipment().addItem(new Potion(1));
		randNum = rand.nextInt(100);
		if(randNum < 40) {
			enemy.addItem(new RatCrossbow());
		}else {
			enemy.addItem(new LongSword());
		}
		
	}

	//Selecciona un comportamiento para el enemigo generado.
	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);
		if(randNum < 30) {
			enemy.setBehaviour(new DumbStrategy());
		}else {
			enemy.setBehaviour(new AgressiveStrategy());
		}
	}

	private Enemy createSkeleton() {
		return new SkeletonWorld2();
	}
	
	private Enemy createHollow() {
		return new HollowWorld2();
	}

	@Override
	public Item generateItem() {
		// TODO Auto-generated method stub
		return null;
	}

}

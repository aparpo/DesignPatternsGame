package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import decoratorPattern.items.Bow;
import decoratorPattern.items.FireStaff;
import decoratorPattern.items.Potion;
import strategyPattern.normalStrategies.AgressiveStrategy;
import strategyPattern.normalStrategies.DumbStrategy;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.crystal.*;
import abstractFactoryPattern.enemies.hollow.*;

public class LevelFactoryWorld1 extends FactoryTemplate{
	
	public LevelFactoryWorld1() {
		super();
	}
	
	@Override
	protected Enemy createEnemy() {
		Enemy enemy;
		int randNum = rand.nextInt(100);
		//Crear un tipo de enemigo u otro basado en la probabilidad
		if(randNum < 55) {
			enemy = createHollow();
		}
		else if(randNum >= 55 && randNum < 90) {
			enemy = createCrysal();
		}
		else {
			enemy = createBlackKnight();
		}
		return enemy;
	}

	@Override
	protected void decorateEnemy(Enemy enemy) {
		//Mejorar al enemigo con habilidades del mundo 1
		//Aqui se pueden cambiar estadisticas o habilidades segun el mundo 
		//Se crean enemigos acordes al nivel de dificultad pero los Hollow del mundo 1 no son siempre exactamente iguales p.e.
		int randNum = rand.nextInt(100);
		enemy.getEquipment().addItem(new Potion(1));
		randNum = rand.nextInt(100);
		
		if(randNum < 30) {
			enemy.addItem(new Bow());
		}else {
			enemy.addItem(new FireStaff());
		}
		
	}
	@Override
	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);
		if(randNum < 60) {
			enemy.setBehaviour(new DumbStrategy());
		}else {
			enemy.setBehaviour(new AgressiveStrategy());
		}
	}

	/*public*/ private Enemy createHollow() {
		return new HollowWorld1();
	}

	/*public*/ private Enemy createCrysal() {
		return new CrystalWorld1();
	}

	/*public*/ private Enemy createBlackKnight() {
		return new BlackKnightWorld1();
	}

	@Override
	public Item generateItem() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}

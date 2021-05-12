package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.items.Bow;
import decoratorPattern.items.FireStaff;
import decoratorPattern.items.Potion;
import abstractFactoryPattern.AbstractEnemyFactory;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.crystal.*;
import abstractFactoryPattern.enemies.hollow.*;
import java.util.Random;

public class EnemyFactoryWorld1 implements AbstractEnemyFactory{
	Random rand = new Random();
	
	public EnemyFactoryWorld1() {
		super();
	}
	
	public Enemy generateEnemy() {
		int randNum = rand.nextInt(100);
		Enemy enemy;
		
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
		
		//Mejorar al enemigo con habilidades del mundo 1
		//Aqui se pueden cambiar estadisticas, estado, objetos o behaviours segun el mundo 
		//Se crean enemigos acordes al nivel de dificultad pero los Hollow del mundo 1 no son siempre exactamente iguales p.e.
		enemy.getEquipment().addItem(new Potion(1));
		randNum = rand.nextInt(100);
		
		if(randNum < 30) {
			enemy.addItem(new Bow());
		}else {
			enemy.addItem(new FireStaff());
		}
		
		return enemy; //Devolver el enemigo mejorado
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
	
	/*public Enemy createSkeleton() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public Enemy createGiant() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public Enemy createCapraDemon() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public static void main(String[] args) {
		AbstractEnemyFactory enemyFactory = new EnemyFactoryWorld1();
		
		Enemy enemy = enemyFactory.generateEnemy();
		
		System.out.print(enemy);
	}*/
}

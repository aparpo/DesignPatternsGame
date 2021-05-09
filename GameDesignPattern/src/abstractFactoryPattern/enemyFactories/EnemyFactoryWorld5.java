package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import abstractFactoryPattern.AbstractEnemyFactory;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.giant.*;
import java.util.Random;

public class EnemyFactoryWorld5 implements AbstractEnemyFactory{
	Random rand = new Random();
	
	public EnemyFactoryWorld5() {
		super();
	}
	
	public Enemy generateEnemy() {
		int randNum = rand.nextInt(100);
		
		if(randNum < 55) {
			return createGiant();
		}
		else {
			return createBlackKnight();
		}
	}
	
	public Enemy createGiant() {
		return new GiantWorld4();
	}
	
	public Enemy createBlackKnight() {
		return new BlackKnightWorld4();
	}
	
	public Enemy createCrysal() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}
	
	public Enemy createSkeleton() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}
	
	public Enemy createHollow() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}
	
	public Enemy createCapraDemon() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

}

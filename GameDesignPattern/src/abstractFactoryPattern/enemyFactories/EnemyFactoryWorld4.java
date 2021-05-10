package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import abstractFactoryPattern.AbstractEnemyFactory;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.giant.*;
import abstractFactoryPattern.enemies.capraDemon.*;
import java.util.Random;

public class EnemyFactoryWorld4 implements AbstractEnemyFactory{
	Random rand = new Random();
	
	public EnemyFactoryWorld4() {
		super();
	}
	
	public Enemy generateEnemy() {
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

	public Enemy createCapraDemon() {
		return new CapraDemonWorld4();
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

}

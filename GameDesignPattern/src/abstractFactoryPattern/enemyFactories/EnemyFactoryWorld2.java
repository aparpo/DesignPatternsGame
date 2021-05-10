package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import abstractFactoryPattern.AbstractEnemyFactory;
import abstractFactoryPattern.enemies.skeleton.*;
import abstractFactoryPattern.enemies.hollow.*;
import java.util.Random;

public class EnemyFactoryWorld2 implements AbstractEnemyFactory{
	Random rand = new Random();
	
	public EnemyFactoryWorld2() {
		super();
	}
	
	public Enemy generateEnemy() {
		int randNum = rand.nextInt(100);
		
		if(randNum < 65) {
			return createSkeleton();
		}
		else {
			return createHollow();
		}
	}

	public Enemy createSkeleton() {
		return new SkeletonWorld2();
	}
	
	public Enemy createHollow() {
		return new HollowWorld2();
	}

	public Enemy createCrysal() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public Enemy createBlackKnight() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public Enemy createGiant() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public Enemy createCapraDemon() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

}

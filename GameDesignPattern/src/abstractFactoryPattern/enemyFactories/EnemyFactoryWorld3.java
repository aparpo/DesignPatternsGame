package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import abstractFactoryPattern.AbstractEnemyFactory;
import abstractFactoryPattern.enemies.skeleton.*;
import abstractFactoryPattern.enemies.crystal.*;
import abstractFactoryPattern.enemies.hollow.*;
import java.util.Random;

public class EnemyFactoryWorld3 implements AbstractEnemyFactory{
	Random rand = new Random();
	
	public EnemyFactoryWorld3() {
		super();
	}
	
	public Enemy generateEnemy() {
		int randNum = rand.nextInt(100);
		
		if(randNum < 35) {
			return createSkeleton();
		}
		else if(randNum >= 35 && randNum < 70) {
			return createCrysal();
		}
		else {
			return createHollow();
		}
	}

	public Enemy createCrysal() {
		return new CrystalWorld3();
	}
	
	public Enemy createSkeleton() {
		return new SkeletonWorld3();
	}
	
	public Enemy createHollow() {
		return new HollowWorld3();
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


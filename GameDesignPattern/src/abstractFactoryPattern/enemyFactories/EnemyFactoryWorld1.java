package abstractFactoryPattern.enemyFactories;
import base.Enemy;
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
		
		if(randNum < 55) {
			return createHollow();
		}
		else if(randNum >= 55 && randNum < 90) {
			return createCrysal();
		}
		else {
			return createBlackKnight();
		}
	}

	public Enemy createHollow() {
		return new HollowWorld1();
	}

	public Enemy createCrysal() {
		return new CrystalWorld1();
	}

	public Enemy createBlackKnight() {
		return new BlackKnightWorld1();
	}
	
	public Enemy createSkeleton() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public Enemy createGiant() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

	public Enemy createCapraDemon() {
		throw new IllegalStateException("Invalid Enemy Generation");
	}

}

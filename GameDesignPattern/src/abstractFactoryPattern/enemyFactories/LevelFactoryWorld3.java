package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.skeleton.*;
import abstractFactoryPattern.enemies.crystal.*;
import abstractFactoryPattern.enemies.hollow.*;
import java.util.Random;

public class LevelFactoryWorld3 extends FactoryTemplate{
	int randNum = rand.nextInt(100);
	
	public LevelFactoryWorld3() {
		super();
	}
	@Override
	public Item generateItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Enemy createEnemy() {
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

	@Override
	protected void decorateEnemy(Enemy enemy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void finishEnemy(Enemy enemy) {
		// TODO Auto-generated method stub
		
	}

	private Enemy createCrysal() {
		return new CrystalWorld3();
	}
	
	private Enemy createSkeleton() {
		return new SkeletonWorld3();
	}
	
	private Enemy createHollow() {
		return new HollowWorld3();
	}



}


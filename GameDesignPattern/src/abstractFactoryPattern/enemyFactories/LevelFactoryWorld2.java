package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.skeleton.*;
import abstractFactoryPattern.enemies.hollow.*;
import java.util.Random;

public class LevelFactoryWorld2 extends FactoryTemplate{
	
	public LevelFactoryWorld2() {
		super();
	}
	@Override
	public Item generateItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Enemy createEnemy() {
		int randNum = rand.nextInt(100);
		if(randNum < 65) {
			return createSkeleton();
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

	private Enemy createSkeleton() {
		return new SkeletonWorld2();
	}
	
	private Enemy createHollow() {
		return new HollowWorld2();
	}

	

}

package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.skeleton.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Sif;
import abstractFactoryPattern.enemies.hollow.*;
import java.util.Random;

//Mundo basado en el estado envenenado
public class LevelFactoryWorld2 extends FactoryTemplate{ 
	
	public LevelFactoryWorld2() {
		super();
	}
	
	public Boss generateBoss() {
		//Genera el Boss final correspondiente al nivel en el que nos encontremos
		return new Sif();
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

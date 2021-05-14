package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.giant.*;
import java.util.Random;

public class LevelFactoryWorld5 extends FactoryTemplate{
	
	public LevelFactoryWorld5() {
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
		
		if(randNum < 55) {
			return createGiant();
		}
		else {
			return createBlackKnight();
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
	
	
	private Enemy createGiant() {
		return new GiantWorld4();
	}
	
	private Enemy createBlackKnight() {
		return new BlackKnightWorld4();
	}

	

}

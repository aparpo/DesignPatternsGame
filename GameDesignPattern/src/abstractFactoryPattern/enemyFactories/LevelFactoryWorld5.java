package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Gwyn;
import abstractFactoryPattern.enemies.giant.*;
import java.util.Random;

public class LevelFactoryWorld5 extends FactoryTemplate{
	
	public LevelFactoryWorld5() {
		super();
	}
	
	public Boss generateBoss() {
		//Genera el Boss final correspondiente al nivel en el que nos encontremos
		return new Gwyn();
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

package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import decoratorPattern.Item;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Nito;
import abstractFactoryPattern.enemies.giant.*;
import abstractFactoryPattern.enemies.capraDemon.*;
import java.util.Random;

public class LevelFactoryWorld4 extends FactoryTemplate{
	
	
	public LevelFactoryWorld4() {
		super();
	}

	public Boss generateBoss() {
		//Genera el Boss final correspondiente al nivel en el que nos encontremos
		return new Nito();
	}

	@Override
	public Item generateItem() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Enemy createEnemy() {
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

	@Override
	protected void decorateEnemy(Enemy enemy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void finishEnemy(Enemy enemy) {
		// TODO Auto-generated method stub
		
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

}

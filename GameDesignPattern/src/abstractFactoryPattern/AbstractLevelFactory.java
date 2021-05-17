package abstractFactoryPattern;

import abstractFactoryPattern.enemies.bosses.Boss;
import base.Enemy;
import decoratorPattern.Item;

public interface AbstractLevelFactory {	
	public Enemy generateEnemy();
	public Item generateItem();
	public Boss generateBoss();
	
}

package abstractFactoryPattern;

import abstractFactoryPattern.enemies.bosses.Boss;
import base.Enemy;
import decoratorPattern.Item;
import decoratorPattern.ItemDecorator;

public interface AbstractLevelFactory {	
	public Enemy generateEnemy();
	public ItemDecorator generateItem();
	public Boss generateBoss();
	
}

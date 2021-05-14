package abstractFactoryPattern;

import base.Enemy;
import decoratorPattern.Item;

public interface AbstractLevelFactory {	
	public Enemy generateEnemy();
	public Item generateItem();
	
}

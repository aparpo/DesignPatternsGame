package abstractFactoryPattern;

import base.Enemy;
import decoratorPattern.Item;

public interface AbstractLevelFactory {
	public Enemy createEnemy();
	public Item createItem();
}

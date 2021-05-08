package abstractFactoryPattern;

import base.Enemy;
import decoratorPattern.Item;

public interface AbstractEnemyFactory {
	public Enemy createEnemy();
	public Item createEquipment();
}

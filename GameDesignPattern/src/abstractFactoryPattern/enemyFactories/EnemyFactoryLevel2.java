package abstractFactoryPattern.enemyFactories;

import abstractFactoryPattern.AbstractEnemyFactory;
import abstractFactoryPattern.enemies.hollow.HollowWorld2;
import abstractFactoryPattern.enemies.skeleton.SkeletonWorld2;
import base.Enemy;
import decoratorPattern.Item;

public class EnemyFactoryLevel2 implements AbstractEnemyFactory{
	public Enemy createEnemy() {
		Enemy createdEnemy;
		if((int)Math.random()*1 == 0) {
			createdEnemy = new SkeletonWorld2();
		}else {
			createdEnemy = new HollowWorld2();
		}
		
		return createdEnemy;
	}
	public Item createEquipment() {
		// TODO Auto-generated method stub
		return null;
	}
}

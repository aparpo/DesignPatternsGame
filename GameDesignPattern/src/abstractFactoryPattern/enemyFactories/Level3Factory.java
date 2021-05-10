package abstractFactoryPattern.enemyFactories;

import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.enemies.hollow.HollowWorld3;
import abstractFactoryPattern.enemies.skeleton.SkeletonWorld3;
import base.Enemy;
import decoratorPattern.Item;

public class Level3Factory implements AbstractLevelFactory{
	public Enemy createEnemy() {
		Enemy createdEnemy;
		if((int)Math.random()*1 == 0) {
			createdEnemy = new SkeletonWorld3();
		}else {
			createdEnemy = new HollowWorld3();
		}
		
		return createdEnemy;
	}
	public Item createItem() {
		// TODO Auto-generated method stub
		return null;
	}
}

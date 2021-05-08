package abstractFactoryPattern.enemyFactories;

import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.enemies.hollow.HollowWorld2;
import abstractFactoryPattern.enemies.skeleton.SkeletonWorld2;
import base.Enemy;
import decoratorPattern.Item;

public class Level2Factory implements AbstractLevelFactory{
	public Enemy createEnemy() {
		Enemy createdEnemy;
		if((int)Math.random()*1 == 0) {
			createdEnemy = new SkeletonWorld2();
		}else {
			createdEnemy = new HollowWorld2();
		}
		
		return createdEnemy;
	}
	public Item createItem() {
		// TODO Auto-generated method stub
		return null;
	}
}

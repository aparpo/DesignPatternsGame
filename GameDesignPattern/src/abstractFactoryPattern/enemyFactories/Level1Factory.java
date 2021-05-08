package abstractFactoryPattern.enemyFactories;
import abstractFactoryPattern.AbstractLevelFactory;
import abstractFactoryPattern.enemies.hollow.HollowWorld1;
import abstractFactoryPattern.enemies.skeleton.SkeletonWorld1;
import base.Enemy;
import decoratorPattern.*;
import decoratorPattern.Item;
import decoratorPattern.items.*;

public class Level1Factory implements AbstractLevelFactory{

	//Item possibleItemsWorld1[] = {new ElectricShield(new RegularItem()), new Bow(new RegularItem()), new Thornmail(new RegularItem()), new VampiricSword(new RegularItem())};
	
	public Enemy createEnemy() {
		Enemy createdEnemy;
		if((int)Math.random()*1 == 0) {
			createdEnemy = new SkeletonWorld1();
		}else {
			createdEnemy = new HollowWorld1();
		}
		
		return createdEnemy;
	}

	public Item createItem() {
		// TODO Auto-generated method stub
		return null;
	}
}

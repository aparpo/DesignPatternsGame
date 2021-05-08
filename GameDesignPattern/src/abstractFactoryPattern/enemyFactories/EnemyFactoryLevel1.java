package abstractFactoryPattern.enemyFactories;
import abstractFactoryPattern.AbstractEnemyFactory;
import abstractFactoryPattern.enemies.hollow.HollowWorld1;
import abstractFactoryPattern.enemies.skeleton.SkeletonWorld1;
import base.Enemy;
import decoratorPattern.*;
import decoratorPattern.Item;
import decoratorPattern.items.*;

public class EnemyFactoryLevel1 implements AbstractEnemyFactory{

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

	public Item createEquipment() {
		// TODO Auto-generated method stub
		return null;
	}

	//new enemy
	//enemy.setEquipment(new Bow(enemy.getEquipment());
}

package com.utad.project.abstractFactoryPattern;

import com.utad.project.abstractFactoryPattern.enemies.bosses.Boss;
import com.utad.project.base.Enemy;
import com.utad.project.decoratorPattern.Item;
import com.utad.project.decoratorPattern.ItemDecorator;

public interface AbstractLevelFactory {	
	public Enemy generateEnemy();
	public ItemDecorator generateItem();
	public Boss generateBoss();
	
}

package strategyPattern;

import abstractFactoryPattern.Enemy;
import base.Character;

public abstract class template {
	public void doAction(Enemy enemy, Character player) {
		int possibilityDefense = enemy.getTemplate().worthDefense( enemy,player);
		int possibilityAttack = enemy.getTemplate().worthAttack( enemy, player);
		int possibilityNeutral = 1;
		int total = possibilityAttack + possibilityDefense  + possibilityNeutral;
		int eleccion = (int) Math.random()*total;
		
		if(eleccion < possibilityAttack) {
			enemy.getTemplate().attack(enemy, player);
		}else if(eleccion < possibilityAttack + possibilityDefense) {
			enemy.getTemplate().defense(enemy, player);
		}else if(eleccion < possibilityAttack + possibilityDefense  + possibilityNeutral) {
			enemy.getTemplate().neutral(enemy, player);
		}
		
	}
	
}

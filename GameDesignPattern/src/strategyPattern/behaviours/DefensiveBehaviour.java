package strategyPattern.behaviours;
import java.util.Random;

import base.Enemy;
import strategyPattern.Actions;

public class DefensiveBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction(Enemy enemy) {
		int num = rand.nextInt(100);
		
		if(num < 28) {
			attack(enemy);
		}
		
		if(num >= 28 && num < 98) {
			defend(enemy);
		}
		
		else {
			run(enemy);
		}
	}
}



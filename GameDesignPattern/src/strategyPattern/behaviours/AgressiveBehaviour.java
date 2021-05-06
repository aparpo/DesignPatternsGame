package strategyPattern.behaviours;
import java.util.Random;

import base.Enemy;
import strategyPattern.Actions;

public class AgressiveBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction(Enemy enemy) {
		int num = rand.nextInt(100);
		
		if(num < 70) {
			attack(enemy);
		}
		
		if(num >= 70 && num < 99) {
			defend(enemy);
		}
		
		else {
			run(enemy);
		}
	}
}

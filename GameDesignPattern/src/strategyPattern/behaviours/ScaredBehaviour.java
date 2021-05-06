package strategyPattern.behaviours;
import java.util.Random;

import base.Enemy;
import strategyPattern.Actions;

public class ScaredBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction(Enemy enemy) {
		int num = rand.nextInt(100);
		
		if(num < 5) {
			attack(enemy);
		}
		
		if(num >= 5 && num < 10) {
			defend(enemy);
		}
		
		else {
			run(enemy);
		}
	}
}

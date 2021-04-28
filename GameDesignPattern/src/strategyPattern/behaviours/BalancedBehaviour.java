package strategyPattern.behaviours;
import java.util.Random;
import strategyPattern.Actions;
import abstractFactoryPattern.Enemy;

public class BalancedBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction(Enemy enemy) {
		int num = rand.nextInt(100);
		
		if(num < 49) {
			attack(enemy);
		}
		
		if(num >= 49 && num < 98) {
			defend(enemy);
		}
		
		else {
			run(enemy);
		}
	}
}

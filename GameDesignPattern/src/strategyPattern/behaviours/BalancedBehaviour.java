package strategyPattern.behaviours;
import java.util.Random;
import strategyPattern.Actions;

public class BalancedBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction() {
		int num = rand.nextInt(100);
		
		if(num < 49) {
			attack();
		}
		
		if(num >= 49 && num < 98) {
			defend();
		}
		
		else {
			run();
		}
	}
}

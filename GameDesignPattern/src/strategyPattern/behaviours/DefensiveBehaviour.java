package strategyPattern.behaviours;
import java.util.Random;
import strategyPattern.Actions;

public class DefensiveBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction() {
		int num = rand.nextInt(100);
		
		if(num < 28) {
			attack();
		}
		
		if(num >= 28 && num < 98) {
			defend();
		}
		
		else {
			run();
		}
	}
}



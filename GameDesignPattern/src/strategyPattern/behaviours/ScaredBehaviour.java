package strategyPattern.behaviours;
import java.util.Random;
import strategyPattern.Actions;

public class ScaredBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction() {
		int num = rand.nextInt(100);
		
		if(num < 5) {
			attack();
		}
		
		if(num >= 5 && num < 10) {
			defend();
		}
		
		else {
			run();
		}
	}
}

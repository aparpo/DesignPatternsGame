package strategyPattern.behaviours;
import java.util.Random;
import strategyPattern.Actions;

public class AgressiveBehaviour extends Actions{
	Random rand = new Random();
	
	public void doAction() {
		int num = rand.nextInt(100);
		
		if(num < 70) {
			attack();
		}
		
		if(num >= 70 && num < 99) {
			defend();
		}
		
		else {
			run();
		}
	}
}

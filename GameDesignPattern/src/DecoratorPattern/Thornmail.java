package DecoratorPattern;

public class Thornmail extends PassiveItemDecorator{
	public Thornmail(Item equipment) {
		super(equipment, "Thornmail", 0, 5, 0, 20, 0);
	}
	
	@Override
	public Equipment modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		if(life <= maxLife/2) { //Improves defense level if life is below half
			defense*=2; 
		}
		return new Equipment(life, maxLife, attack, defense, speed);
	}
}

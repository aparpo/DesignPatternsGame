package decoratorPattern.items;

import decoratorPattern.Item;
import decoratorPattern.PassiveItemDecorator;
import decoratorPattern.Stats;

public class Thornmail extends PassiveItemDecorator{
	public Thornmail(Item equipment) {
		super(equipment, "Thornmail", 0, 5, 0, 20, 0);
	}
	
	@Override
	public Stats modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		if(life <= maxLife/2) { //Mejora la defensa si la vida esta por debajo de la mitad
			defense*=2; 
		}
		return new Stats(life, maxLife, attack, defense, speed);
	}
}

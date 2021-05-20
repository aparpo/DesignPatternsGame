package decoratorPattern.items;

import base.Stats;
import decoratorPattern.Item;
import decoratorPattern.PassiveItemDecorator;
import decoratorPattern.Tier;

public class Thornmail extends PassiveItemDecorator{ //Aumenta pasivamente la defensa
	
	public Thornmail() {
		this(null);
	}
	public Thornmail(Item equipment) {
		super(equipment, "Thornmail", new Stats(0, 5, 0, 20, -1),Tier.B);
	}
	
	@Override
	public Stats modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		int newDefense = 0;
		if(life <= maxLife/2) { //Mejora la defensa si la vida esta por debajo de la mitad
			newDefense= defense*2; 
		}
		return new Stats(0,0,0,newDefense,0);
	}
}

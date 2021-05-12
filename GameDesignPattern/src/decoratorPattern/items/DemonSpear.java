package decoratorPattern.items;

import base.*;
import decoratorPattern.*;

public class DemonSpear extends PassiveItemDecorator{ 

	public DemonSpear() {
		this(null);
	}
	public DemonSpear(Item equipment) {
		super(equipment, "Demon Spear", new Stats(0, 0, 20, 0, 0), Tier.S);
	}
	

	@Override
	public Stats modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		return new Stats(life, maxLife, 2*attack, -defense, speed+1); //Duplica el ataque y reduce a 0 la defensa. Aumenta la velocidad
	}

}

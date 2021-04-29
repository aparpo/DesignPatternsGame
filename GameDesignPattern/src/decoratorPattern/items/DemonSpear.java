package decoratorPattern.items;

import decoratorPattern.*;

public class DemonSpear extends PassiveItemDecorator{ 

	public DemonSpear(Equipment equipment) {
		super(equipment, "Demon Spear", 0, 0, 20, 0, 0);
	}
	

	@Override
	public Stats modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		return new Stats(life, maxLife, 2*attack, -defense, speed+1); //Duplica el ataque y reduce a 0 la defensa. Aumenta la velocidad
	}

}

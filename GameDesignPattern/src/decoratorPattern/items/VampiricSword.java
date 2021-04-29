package decoratorPattern.items;

import decoratorPattern.Equipment;
import decoratorPattern.PassiveItemDecorator;
import decoratorPattern.Stats;

public class VampiricSword extends PassiveItemDecorator{ 

	public VampiricSword(Equipment equipment) {
		super(equipment, "Vampiric Sword", 0, 0, 20, 0, 0);
	}
	

	@Override
	public Stats modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		life+=0.1*attack; //Restaura vida en funcion del ataque
		if(life > maxLife) {
			life=maxLife;
		}
		return new Stats(life, maxLife, attack, defense, speed);
	}

}

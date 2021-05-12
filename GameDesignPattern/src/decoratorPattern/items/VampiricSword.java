package decoratorPattern.items;

import base.Stats;
import decoratorPattern.Item;
import decoratorPattern.PassiveItemDecorator;
import decoratorPattern.Tier;

public class VampiricSword extends PassiveItemDecorator{ 

	public VampiricSword(Item equipment) {
		super(equipment, "Vampiric Sword", new Stats(0, 0, 20, 0, 0), Tier.B);
	}
	

	public VampiricSword(){
		this(null);
	}


	@Override
	public Stats modifyStats(int life, int maxLife, int attack, int defense, int speed) {
		life+=(int)0.1*attack; //Restaura vida en funcion del ataque
		if(life > maxLife) { //Su vida sobrepasa su vida maxima 
			life=maxLife; 
		}
		return new Stats(life, maxLife, attack, defense, speed);
	}

}

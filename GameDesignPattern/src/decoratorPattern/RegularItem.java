package decoratorPattern;

import base.Stats;

public class RegularItem extends ItemDecorator{ //Decoradores que solo modifican las estadisticas
	public RegularItem() {
		super();
	}
	public RegularItem(Item equipment, String name, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed, Tier.C);
	}
	
	public RegularItem(Item equipment, String name, Stats stats) {
		this(equipment, name, stats.getLife(), stats.getMaxLife(), stats.getAttack(), stats.getDefense(), stats.getSpeed());
	}

}

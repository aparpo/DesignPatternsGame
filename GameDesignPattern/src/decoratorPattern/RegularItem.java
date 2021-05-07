package decoratorPattern;

import base.Stats;

public class RegularItem extends ItemDecorator{ //Decoradores que solo modifican las estadisticas
	
	public RegularItem(Item equipment, String name, int life, int maxLife, int attack, int defense, int speed, Tier tier) {
		super(equipment, name, life, maxLife, attack, defense, speed, tier);
	}
	
	public RegularItem(Item equipment, String name, Stats stats, Tier tier) {
		this(equipment, name, stats.getLife(), stats.getMaxLife(), stats.getAttack(), stats.getDefense(), stats.getSpeed(), tier);
	}

}

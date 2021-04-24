package decoratorPattern;

public class RegularItem extends ItemDecorator{

	public RegularItem(Item equipment) {
		super(equipment);
	}
	
	public RegularItem(Item equipment, String name, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed);
	}

}

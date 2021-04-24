package DecoratorPattern;

public class Spell extends ActiveItemDecorator{
	public Spell(Item equipment) {
		super(equipment);
	}
	
	public Spell(Item equipment,String name, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed);
	}
}

package decoratorPattern;

public class Potion extends UsableItemDecorator{
	
	public Potion(Item equipment, int amount) {
		super(equipment, "Potion", 50, 0, 0, 0, 0, amount);
	}
}

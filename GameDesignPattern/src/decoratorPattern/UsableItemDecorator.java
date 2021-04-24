package decoratorPattern;

public abstract class UsableItemDecorator extends ActiveItemDecorator {
	protected int amount;
	
	public UsableItemDecorator(Item equipment) {
		super(equipment);
	}
	
	public UsableItemDecorator(Item equipment, String name, int life, int maxLife, int attack, int defense, int speed, int amount) {
		super(equipment, name, life, maxLife, attack, defense, speed);
		this.amount = amount;
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	
}

package decoratorPattern;

public abstract class ActiveItemDecorator extends ItemDecorator {
	String action;
	
	public ActiveItemDecorator(Item equipment) {
		super(equipment);
	}
	
	public ActiveItemDecorator(Item equipment, String name, int life, int maxLife, int attack, int defense, int speed) {
		super(equipment, name, life, maxLife, attack, defense, speed);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}

package DecoratorPattern;

public abstract class ActiveItemDecorator extends ItemDecorator {
	String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}

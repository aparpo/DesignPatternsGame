package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import decoratorPattern.*;

public class Hollow extends Enemy{
	protected final Stats hollowBaseStats = new Stats(250, 250, 50, 50 ,25);
	protected String hollowType;
	
	public Hollow(String hollowType) {
		super("Hollow");
		this.hollowType = hollowType;
	}
}

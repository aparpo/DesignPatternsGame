package abstractFactoryPattern.enemies.hollow;
import abstractFactoryPattern.*;
import decoratorPattern.*;

public class Hollow extends Enemy{
	protected final Stats hollowBaseStats = new Stats(250, 250, 50, 50 ,25);
	protected String hollowName;
	
	public Hollow(String hollowName) {
		super("Hollow");
		this.hollowName = hollowName;
	}
}

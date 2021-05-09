package abstractFactoryPattern.enemies.crystal;
import base.Enemy;
import base.Stats;

public class Crystal extends Enemy{
	protected final Stats crystalBaseStats = new Stats(100, 100, 110, 15, 50);
	protected String crystalName;
	
	public Crystal(String hollowName) {
		super("Crystal Enemy");
		this.crystalName = hollowName;
	}
}

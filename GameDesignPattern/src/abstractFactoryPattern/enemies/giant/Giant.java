package abstractFactoryPattern.enemies.giant;
import base.Enemy;
import base.Stats;

public class Giant extends Enemy{
	protected final Stats giantBaseStats = new Stats(500, 500, 50, 95, 5);
	protected String giantName;
	
	public Giant(String hollowName) {
		super("Giant");
		this.giantName = hollowName;
	}
}

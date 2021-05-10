package abstractFactoryPattern.enemies.capraDemon;
import base.Enemy;
import base.Stats;

public class CapraDemon extends Enemy{
	protected final Stats capraDemonBaseStats = new Stats(350, 350, 85, 50, 10);
	protected String capraDemonName;
	
	public CapraDemon(String hollowName) {
		super("Capra Demon");
		this.capraDemonName = hollowName;
	}
}

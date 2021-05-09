package abstractFactoryPattern.enemies.blackKnight;
import base.Enemy;
import base.Stats;

public class BlackKnight extends Enemy{
	protected final Stats blackKnightBaseStats = new Stats(300, 300, 80, 80, 20);
	protected String blackKnightName;
	
	public BlackKnight(String hollowName) {
		super("Black Knight");
		this.blackKnightName = hollowName;
	}
}

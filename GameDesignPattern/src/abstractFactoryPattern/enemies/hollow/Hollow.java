package abstractFactoryPattern.enemies.hollow;
import base.Enemy;
import base.Stats;

public abstract class Hollow extends Enemy{
	//Estadisticas Base de los Hollow, las cuales son multiplicadas posteriormente por el factor de multiplicidad del mundo en el que son creados.
	protected final Stats hollowBaseStats = new Stats(60, 60, 30, 30, 2);
	
	public Hollow(String enemyName) {
		super(enemyName,"");
	}
}

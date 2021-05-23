package abstractFactoryPattern.enemies.crystal;
import base.Enemy;
import base.Stats;

public class Crystal extends Enemy{
	//Estadisticas Base de los Crystal, las cuales son multiplicadas posteriormente por el factor de multiplicidad del mundo en el que son creados.
	protected final Stats crystalBaseStats = new Stats(30, 30, 80, 15, 1);
	
	public Crystal(String enemyName) {
		super(enemyName,"");
	}
}

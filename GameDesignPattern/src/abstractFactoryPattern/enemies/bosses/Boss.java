package abstractFactoryPattern.enemies.bosses;
import base.Enemy;

public abstract class Boss extends Enemy{
	//A diferencia del resto de enemigos, los Bosses no requieren de estadisticas base ya que estos son independientes entre si, 
	//compartiendo unicamente la caracteristica de Boss.
	
	public Boss(String bossName) {
		super(bossName,"");
	}
}

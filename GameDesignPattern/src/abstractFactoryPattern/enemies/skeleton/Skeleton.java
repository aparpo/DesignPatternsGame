package abstractFactoryPattern.enemies.skeleton;
import abstractFactoryPattern.*;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;

public abstract class Skeleton extends Enemy{ //Clase modelo, a eliminar al acabar el patron
	
	public Skeleton() {
		super("Skeleton");
		this.equipment = new RegularItem(equipment,"custom",100, 100, 50, 30 ,2); //vida, vidaMax, ataque,defensa,velocidad
		this.equipment =  new Bow(equipment);
		this.equipment = new Shield(equipment);
	}
}

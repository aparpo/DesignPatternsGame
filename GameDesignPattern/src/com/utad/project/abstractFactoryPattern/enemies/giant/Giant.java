package com.utad.project.abstractFactoryPattern.enemies.giant;
import com.utad.project.base.Enemy;
import com.utad.project.base.Stats;

public abstract class Giant extends Enemy{
	//Estadisticas Base de los Giant, las cuales son multiplicadas posteriormente por el factor de multiplicidad del mundo en el que son creados.
	protected final Stats giantBaseStats = new Stats(100, 100, 40, 65, 1);
	
	public Giant(String enemyName) {
		super(enemyName,"");
	}
}

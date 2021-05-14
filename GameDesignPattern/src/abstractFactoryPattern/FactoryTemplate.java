package abstractFactoryPattern;

import java.util.Random;

import base.Enemy;

public abstract class FactoryTemplate implements AbstractLevelFactory{
	protected Random rand = new Random();
	
	public final Enemy generateEnemy() {
		Enemy enemy = createEnemy();
		decorateEnemy(enemy);
		finishEnemy(enemy);
		
		return enemy;
	}
	
	//Crear al enemigo 
	protected abstract Enemy createEnemy();
	//Decorarlo con items del nivel
	protected abstract void decorateEnemy(Enemy enemy);
	//Cambiar el estado / darle un BehaviourStrategy/ etc.
	protected abstract void finishEnemy(Enemy enemy);
}

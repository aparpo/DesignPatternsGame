package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import base.Stats;
import decoratorPattern.Item;
import decoratorPattern.ItemDecorator;
import decoratorPattern.RegularItem;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;
import abstractFactoryPattern.FactoryTemplate;
import abstractFactoryPattern.enemies.skeleton.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.OrsteinAndSmough;
import abstractFactoryPattern.enemies.crystal.*;
import abstractFactoryPattern.enemies.hollow.*;


public class LevelFactoryWorld3 extends FactoryTemplate{
	
	int skeletonCount=0;
	int hollowCount = 0;
	int crystalCount = 0;
	int itemCount = 0;
	
	public LevelFactoryWorld3() {
		super();
	}

	//Genera el Boss final correspondiente al nivel en el que nos encontremos
	public Boss generateBoss() {
		return new OrsteinAndSmough();
	}
	
	//Genera un enemigo.
	protected Enemy createEnemy() {
		int randNum = rand.nextInt(100);
		if(randNum < 35) {
			return createSkeleton();
		}
		else if(randNum >= 35 && randNum < 70) {
			return createCrysal();
		}
		else {
			return createHollow();
		}
	}

	//Selecciona un arma para el enemigo generado.
	protected void decorateEnemy(Enemy enemy) {
		//Mejorar al enemigo con habilidades del mundo 1
		//Aqui se pueden cambiar estadisticas o habilidades segun el mundo 
		//Se crean enemigos acordes al nivel de dificultad pero los Hollow del mundo 1 no son siempre exactamente iguales p.e.
		int randNum = rand.nextInt(100);
		enemy.getEquipment().addItem(new Potion(2));
		randNum = rand.nextInt(100);
		if(randNum < 20) {
			enemy.addItem(new DemonSpear());
		}
		else if (randNum >= 20 && randNum < 60) {
			enemy.addItem(new FireStaff());
		}
		else {
			enemy.addItem(new SolarAegis());
		}
	}

	//Selecciona un comportamiento para el enemigo generado.
	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);
		if(randNum < 15) {
			enemy.setBehaviour(new DumbStrategy());
		}
		else if (randNum >= 15 && randNum < 40) {
			enemy.setBehaviour(new DefensiveStrategy());
		}
		else {
			enemy.setBehaviour(new AgressiveStrategy());
		}
	}

	private Enemy createCrysal() {
		crystalCount++;
		return new CrystalWorld3(crystalCount);
	}
	
	private Enemy createSkeleton() {
		skeletonCount++;
		return new SkeletonWorld3(skeletonCount);
	}
	
	private Enemy createHollow() {
		hollowCount++;
		return new HollowWorld3(hollowCount);
	}

	public ItemDecorator generateItem() {
		//Genera items (de tres en tres) pertenencientes a una clase concreta
		int randNum = rand.nextInt(100);
		itemCount++;
		if(itemCount%3==0) { //Regulares
			//Estadisticas desequilibradas
			Stats stats = new Stats(0,rand.nextInt(20),rand.nextInt(50),rand.nextInt(20),rand.nextInt(2));
			return new RegularItem("Forgotten sword",stats);
		}else if (itemCount%3 == 1) { //Con Activa
			if(randNum < 40) {
				return new SolarAegis();
			}else {
				return new ElectricShield();
			}
		}else { //Con Pasiva
			if(randNum < 40) {
				return new VampiricSword();
			}else {
				return new Thornmail();
			}
		}
		
	}

}


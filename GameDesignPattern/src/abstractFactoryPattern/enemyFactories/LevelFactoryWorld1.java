package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.bossStrategies.HardStrategy;
import strategyPattern.bossStrategies.HealerStrategy;
import strategyPattern.bossStrategies.MediumStrategy;
import strategyPattern.normalStrategies.*;

import java.util.ArrayList;
import java.util.List;

import abstractFactoryPattern.*;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.bosses.Boss;
import abstractFactoryPattern.enemies.bosses.Quelaag;
import abstractFactoryPattern.enemies.crystal.*;
import abstractFactoryPattern.enemies.hollow.*;

public class LevelFactoryWorld1 extends FactoryTemplate{
	
	private String[] names = {"axe","dagger","spear","armor"};
	private String[] adjectives = {"Iron","Wood","Plastic"};
	private List<ItemDecorator> items = new ArrayList<ItemDecorator>();
	private int basePower = 20;
	
	int hollowCount = 0;
	int crystalCount = 0;
	int knightCount = 0;
	
	public LevelFactoryWorld1() {
		super();
		createItemList();
	}
	
	//Genera el Boss final correspondiente al nivel en el que nos encontremos
	public Boss generateBoss() {
		return new Quelaag();
	}
	
	//Genera un enemigo.
	protected Enemy createEnemy() {
		Enemy enemy;
		int randNum = rand.nextInt(100);
		//Crear un tipo de enemigo u otro basado en la probabilidad
		if(randNum < 55) {
			enemy = createHollow();
		}
		else if(randNum >= 55 && randNum < 90) {
			enemy = createCrysal();
		}
		else {
			enemy = createBlackKnight();
		}
		return enemy;
	}

	//Selecciona un arma para el enemigo generado.
	protected void decorateEnemy(Enemy enemy) {
		//Mejorar al enemigo con habilidades del mundo 1
		//Aqui se pueden cambiar estadisticas o habilidades segun el mundo 
		//Se crean enemigos acordes al nivel de dificultad pero los Hollow del mundo 1 no son siempre exactamente iguales p.e.
		int randNum = rand.nextInt(100);
		enemy.getEquipment().addItem(new Potion(1));
		randNum = rand.nextInt(100);
		
		if(randNum < 30) {
			enemy.addItem(new Bow());
		}else {
			enemy.addItem(new FireStaff());
		}
		
	}
	
	//Selecciona un comportamiento para el enemigo generado.
	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);
		if(randNum < 60) {
			enemy.setBehaviour(new DumbStrategy());
		}else {
			enemy.setBehaviour(new AgressiveStrategy());
		}
	}

	private Enemy createHollow() {
		hollowCount++;
		return new HollowWorld1(hollowCount);
	}
	private Enemy createCrysal() {
		crystalCount++;
		return new CrystalWorld1(crystalCount);
	}
	private Enemy createBlackKnight() {
		knightCount++;
		return new BlackKnightWorld1(knightCount);
	}
	
	//Crea una lista de objetos adecuados al nivel de la factoria
	private void createItemList() {
		items.add(new Bow());
		items.add(new FireStaff());
		items.add(new Potion(3));
		items.add(new Antidote(1));
		items.add(new Thornmail());
		items.add(new SolarAegis());
	}

	@Override
	public ItemDecorator generateItem() {
		int randNum = rand.nextInt(100);
		ItemDecorator item;
		if(randNum < 60 || items.size() <= 0) { //Crear un regular item  con 60% de probabilidad
			//Stats aleatorias
			Stats stats = new Stats(0,rand.nextInt(basePower),rand.nextInt(basePower),rand.nextInt(basePower),rand.nextInt(2));
			
			//Elaborar un nombre aleatorio
			String name = adjectives[rand.nextInt(adjectives.length)] + " "+ names[rand.nextInt(names.length)];
			item = new RegularItem(name,stats);
			
		}else {//Devolver un item de los posibles para el mundo 1
			if(items.size()==0) createItemList();
			randNum = rand.nextInt(items.size());
			item = items.get(randNum);
			items.remove(randNum);
		}
		return item;
	}
	
}

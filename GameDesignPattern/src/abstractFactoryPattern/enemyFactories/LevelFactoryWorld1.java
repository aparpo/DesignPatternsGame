package abstractFactoryPattern.enemyFactories;
import base.Enemy;
import base.Stats;
import decoratorPattern.*;
import decoratorPattern.items.*;
import strategyPattern.normalStrategies.*;

import java.util.ArrayList;
import java.util.List;

import abstractFactoryPattern.*;
import abstractFactoryPattern.enemies.blackKnight.*;
import abstractFactoryPattern.enemies.crystal.*;
import abstractFactoryPattern.enemies.hollow.*;

public class LevelFactoryWorld1 extends FactoryTemplate{
	
	private String[] names = {"sword","dagger","spear","armor"};
	private String[] adjectives = {"iron","wood","plastic"};
	private List<Item> items = new ArrayList<Item>();
	private int basePower = 20;
	
	public LevelFactoryWorld1() {
		super();
		createItemList();
	}
	
	@Override
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
	@Override
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
	@Override
	protected void finishEnemy(Enemy enemy) {
		int randNum = rand.nextInt(100);
		if(randNum < 60) {
			enemy.setBehaviour(new DumbStrategy());
		}else {
			enemy.setBehaviour(new AgressiveStrategy());
		}
	}

	private Enemy createHollow() {
		return new HollowWorld1();
	}
	private Enemy createCrysal() {
		return new CrystalWorld1();
	}
	private Enemy createBlackKnight() {
		return new BlackKnightWorld1();
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
	public Item generateItem() {
		int randNum = rand.nextInt(100);
		Item item;
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

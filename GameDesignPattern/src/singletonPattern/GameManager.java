package singletonPattern;

import java.util.ArrayList;
import java.util.List;

import base.*;
import base.Character;
import decoratorPattern.ActiveItemDecorator;
import abstractFactoryPattern.*;
import abstractFactoryPattern.enemyFactories.*;

public class GameManager {
	
	private static GameManager manager = new GameManager();
	private List<Action> actions = new ArrayList<Action>(); //Buffer de acciones durante un turno
	private List<Character> characters = new ArrayList<Character>();
	private AbstractLevelFactory factory = new LevelFactoryWorld1();
	private Player player;
	private World currentLevel = World.WORLD1;
	
	private DisplayStrategy displayManager;
	

	private GameManager() {}

	public static GameManager getManager() {
		return manager;
	}

	public static void setManager(GameManager manager) {
		GameManager.manager = manager;
	}
	
	public void play() {
		
		//Comenzar la parte grafica
		displayManager = new ConsoleDisplay();
		
		//Crear al jugador
		player = new Player("Player");
		characters.add(player);
		
		newLevel(currentLevel);
	}
	
	private void turn() {
		orderBySpeed(); //ordenar a los personajes por su velocidad
		
		askPlayer(); //Pedir al jugador su accion

		combat(); //Hacer calculos de combate
		
		prepareNext(); //Preparar el proximo turno	
		
		switch(checkEnd()) {//Comprobar si se ha acabado el nivel o si ha muerto el jugador
		case 0: //Jugador ha muerto
			//Acabar el juego
			System.out.println("You died");
			break;
		case 1: //Solo queda el jugador
			newLevel(World.values()[currentLevel.ordinal()+1]);
			break;
		default:  //Queda mas de un enemigo vivo
			turn(); //Comenzar el siguiente turno
			break;
		}
		
		
	}
	
	//Genera un nuevo nivel
	private void newLevel(World level) {
		
		currentLevel = World.values()[currentLevel.ordinal()+1];
		
		switch(currentLevel.ordinal()) {
		case 1:
			factory = new LevelFactoryWorld1(); 
			break;
		case 2:
			factory = new LevelFactoryWorld2(); 
			break;
		case 3:
			factory = new LevelFactoryWorld3(); 
			break;
		case 4:
			factory = new LevelFactoryWorld4(); 
			break;
		}
		
		//Crear nuevos enemigos
		for(int i = 0; i < (int) level.getComplexFactor()*2;i++) {
			characters.add(factory.generateEnemy());
		}
		System.out.println("Comienza el nivel "+ currentLevel.ordinal());
		//Comenzar a jugar

		turn();
		
	}
	//Pregunta al jugador por su accion
	private void askPlayer() {
		List<ActiveItemDecorator> skills = new ArrayList<ActiveItemDecorator>();
		skills = player.getEquipment().areThereAnyActives(skills);
		//player.selectItem(skills, characters);
		displayManager.askPlayer(player, skills, characters);
	}
	
	private void orderBySpeed() {
		List<Character> aux = new ArrayList<Character>();
		Character max = null;
		while(!characters.isEmpty()) {
			max = characters.get(0);
			for(int i = 0; i < characters.size(); i++) {
				if(characters.get(i).getEquipment().getSpeed() > max.getEquipment().getSpeed()) {
					max = characters.get(i);
				}
			}
			aux.add(max);
			characters.remove(max);
		}
		
		characters = aux;
	}
	
	private void combat() {
		//Calcular las estadisticas modificadas este turno
		for(int i = 0; i < characters.size();i++) {
			characters.get(i).applyStats(characters.get(i).modifyStats()); 
		}
		
		//Pedir las acciones a cada personaje y almacenarlas en el buffer para tratarlas
		for(int i = 0; i < characters.size();i++) {
			characters.get(i).decision(); 
		}
		
		//Aplicar los efectos del estado de cada personaje a las acciones que ha lanzado
		for(int i = 0; i < actions.size(); i++) {
			if(actions.get(i).getUser()!=null) { //Eventos sin usuario directo (ej: envenenamiento)
				actions.get(i).getUser().StatusEffect(actions.get(i));
			}
			
		}
		
		//Resolver por orden
		while(actions.size()>0) {
			
		if(actions.get(0).getUser().isAlive()) { //El actor sigue vivo
			actions.get(0).getTarget().applyStats(actions.get(0).getVariation()); //Ejecutar la accion
		}
		
		actions.remove(0); //Eliminar una vez ejecutada
			
		}
	}
	
	private void prepareNext() {
		//process de los estados
		for(int i = 0; i < characters.size();i++) {
			characters.get(i).getState().process();
		}
		
		//Preparar el siguiente turno
		for(int i = 0; i < characters.size(); i++) {
			characters.get(i).backToNormal();
		}
		
		//Eliminar a los muertos de la lista
		for(int i = 0; i < characters.size();i++) {
			if(!characters.get(i).isAlive()) {
				characters.remove(i);
			}
		}
	}
	
	private int checkEnd() {
		if(!player.isAlive())return 0;
		else return characters.size();
	}
	
	public void informPlayer(String data) {
		displayManager.informPlayer(data);
	}
		

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(List<Character> characters) {
		this.characters = characters;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public AbstractLevelFactory getFactory() {
		return factory;
	}

	public void setFactory(AbstractLevelFactory factory) {
		this.factory = factory;
	}
	
	public DisplayStrategy getDisplayManager() {
		return displayManager;
	}

	public void setDisplayManager(DisplayStrategy displayManager) {
		this.displayManager = displayManager;
	}
}

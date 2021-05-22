package singletonPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import base.*;
import base.Character;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.ItemDecorator;
import decoratorPattern.UsableItemDecorator;
import abstractFactoryPattern.*;
import abstractFactoryPattern.enemyFactories.*;

public class GameManager {
	
	private static GameManager manager = new GameManager();
	private List<Action> actions = new ArrayList<Action>(); //Buffer de acciones durante un turno
	private List<Character> characters = new ArrayList<Character>();
	private List<ItemDecorator> items;
	private AbstractLevelFactory factory = new LevelFactoryWorld1();
	private Player player;
	private World currentLevel = World.WORLD1;
	

	private DisplayStrategy displayManager;
	private CombatManager combatManager;
	

	private GameManager() {}

	public static GameManager getManager() {
		return manager;
	}

	public static void setManager(GameManager manager) {
		GameManager.manager = manager;
	}
	
	public void play() {
		
		Scanner scanner = new Scanner(System.in);
		int option; 
		
		//Crear al jugador
		System.out.println("What is your name?");
		player = new Player(scanner.next());
		characters.add(player);
		
		//Comenzar la parte grafica
		System.out.println("How do you want to play:\n1.Console\n2.Graphic Interface");
		do {
			option = scanner.nextInt();
		}while(option < 1 || option > 2);
		
		switch(option) {
		case 1:
			displayManager = new ConsoleDisplay();
			break;
		case 2:
			displayManager = new WindowDisplay();
			break;
		}
		
		combatManager = new CombatManager();
		
		newLevel(currentLevel);
	}
	
	public void turn() {
		
		informPlayer("New turn");

		combatManager.combat(characters, actions); //Hacer calculos de combate
		
		prepareNext(); //Preparar el proximo turno	
		
		switch(checkEnd()) {//Comprobar si se ha acabado el nivel o si ha muerto el jugador
		case 0: //Jugador ha muerto
			//Acabar el juego
			System.out.println("You lose, start again?");
			return;
		case 1: //Solo queda el jugador
			newLevel(World.values()[currentLevel.ordinal()+1]);
			
			break;
		default:  //Queda mas de un enemigo vivo
			askPlayer(); //Pedir al jugador su proxima accion
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
		displayManager.paint(player, characters);
		informPlayer("The level "+ currentLevel.ordinal()+ " is starting");
		
		//Borrar el buffer de items
		items = new ArrayList<ItemDecorator>();
		for(int i = 0; i < (int) level.getComplexFactor()*3;i++) {
			items.add(factory.generateItem());
		}
		displayManager.askPlayer(player, items);
		
	}
	//Pregunta al jugador por su accion
	public void askPlayer() {
		List<ActiveItemDecorator> skills = new ArrayList<ActiveItemDecorator>();
		skills = player.getEquipment().areThereAnyActives(skills);
		displayManager.askPlayer(player, skills, characters);
	}
	
	public void giveItem(ItemDecorator item) {
		player.addItem(item);
	}
	public void giveItem(String name) {
		
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
				informPlayer(characters.get(i).getName()+" died");
				if(!(characters.get(i) instanceof Player))
				characters.remove(i);
				
			}
		}
		
		//Eliminar objetos inutiles
		for(int i = 0; i < characters.size();i++) {
			List<UsableItemDecorator> list = new ArrayList<UsableItemDecorator>();
			list = characters.get(i).getEquipment().areThereAnyUsables(list);
			for(int j = 0; j < list.size(); j++) {
				System.out.println(list.get(j));
				if(list.get(j).getAmount()<=0) {
					characters.get(i).deleteItem(list.get(j));
				}
			}
		}
		
		characters = combatManager.orderBySpeed(characters); //ordenar a los personajes por su velocidad
		displayManager.paint(player, characters);
	}
	
	private int checkEnd() {
		if(!player.isAlive())return 0;
		else {
			return characters.size();
		}
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

	public CombatManager getCombatManager() {
		return combatManager;
	}

	public void setCombatManager(CombatManager combatManager) {
		this.combatManager = combatManager;
	}
	
	public World getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(World currentLevel) {
		this.currentLevel = currentLevel;
	}

	public List<ItemDecorator> getItems() {
		return items;
	}

	public void setItems(List<ItemDecorator> items) {
		this.items = items;
	}
}

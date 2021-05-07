package singletonPattern;

import java.util.ArrayList;
import java.util.List;

import base.*;
import base.Character;

public class GameManager {
	
	private static GameManager manager = new GameManager();
	private List<Action> actions = new ArrayList<Action>(); //Buffer de acciones durante un turno
	private List<Character> characters = new ArrayList<Character>();
	//la factoria
	private Player player;
	
	private GameManager() {}

	public static GameManager getManager() {
		return manager;
	}

	public static void setManager(GameManager manager) {
		GameManager.manager = manager;
	}
	
	public void turn() {
		orderBySpeed(); //ordenar a los personajes por su velocidad
		
		combat(); //Hacer calculos de combate
		
		prepareNext(); //Preparar el proximo turno		
	}
	
	private void orderBySpeed() {
		List<Character> aux = new ArrayList<Character>();
		Character max = null;
		while(!characters.isEmpty()) {
			max = aux.get(0);
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
		for(int i = 0; i < actions.size(); i++) {
			if(actions.get(i).getUser().isAlive()) { //El actor sigue vivo
				actions.get(i).getTarget().applyStats(actions.get(i).getVariation());
			}
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
}

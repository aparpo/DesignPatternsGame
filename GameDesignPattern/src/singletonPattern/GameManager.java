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
	//puntero a jugador
	
	private GameManager() {}

	public static GameManager getManager() {
		return manager;
	}

	public static void setManager(GameManager manager) {
		GameManager.manager = manager;
	}
	
	public void turn() {
		orderBySpeed(); //ordenar a los personajes por su velocidad
		
		//Calcular las estadisticas modificadas este turno
		for(int i = 0; i < characters.size();i++) {
			characters.get(i).applyStats(characters.get(i).modifyStats()); 
		}
		
		//do actions
		for(int i = 0; i < characters.size();i++) {
			characters.get(i).decision(); 
		}
		
		//aplicar los efectos del estado de cada personaje a las acciones que ha lanzado
		for(int i = 0; i < actions.size(); i++) {
			actions.get(i).getUser().StatusEffect(actions.get(i));
		}
		
		//resolver por orden
		for(int i = 0; i < actions.size(); i++) {
			actions.get(i).getTarget().applyStats(actions.get(i).getVariation());
		}
		
		//pasar a los estados
		
		for(int i = 0; i < characters.size();i++) {
			characters.get(i); 
		}
		//process de los estados
		
		//comprobar
		
		
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
}

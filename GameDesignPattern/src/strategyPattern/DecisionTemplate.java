package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import base.*;
import base.Character;
import decoratorPattern.ActiveItemDecorator;

public abstract class DecisionTemplate {
	
	//Metodo plantilla para elegir la accion que realiza el enemigo
	public final void decision(Enemy user, Player target) {
		int[] options = analize(user, target);
		List<ActiveItemDecorator> skills = getSkills(user);
		selectSkill(options, skills, user, target);
	}
	
	//Se analiza la situacion y se devuelve un array de enteros con la prioridad de cada accion.
	//0. Prioridad de ataque 1. Prioridad de defensa 2. Prioridad de accion neutral 3+. Otros parametros de interes 
	//Por defecto con los metodos abstractos de la clase. Susceptible de cambio para analisis mas complejos (jefes) 
	protected int[] analize(Character enemy, Character player) {
		int[] options = new int[3];
		options[0] = worthAttack(enemy,  player);
		options[1] = worthDefend(enemy,  player);
		options[2] = worthNeutral(enemy,  player);
		return options;
	}
	
	//Devuelven un entero con la prioridad de la acci�n, cero si no es posible o inutil
	protected abstract int worthAttack(Character enemy, Character player);
	protected abstract int worthDefend(Character enemy, Character player);
	protected abstract int worthNeutral(Character enemy, Character player);
	
	//Devuelve la lista con las habilidades del personaje. Por defecto todas. Susceptible de filtrado previo.
	protected List<ActiveItemDecorator> getSkills(Enemy user){
		List<ActiveItemDecorator> skills = new ArrayList<ActiveItemDecorator>();
		skills = user.getEquipment().areThereAnyActives(skills);
		return skills;
	}
	
	//Con la informacion recabada se elige y se usa la habilidad
	protected abstract void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target);
	
	
	
	
}

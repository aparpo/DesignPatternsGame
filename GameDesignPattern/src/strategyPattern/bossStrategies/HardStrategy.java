package strategyPattern.bossStrategies;

import java.util.ArrayList;
import java.util.List;

import base.*;
import decoratorPattern.*;
import strategyPattern.DecisionTemplate;

public class HardStrategy extends DecisionTemplate{

	//Funcion que comprueba que tan "rentable" es atacar
	protected int worthAttack(Enemy enemy, Player player) {
		//Creamos una lista con los items del enemigo (el atacante) y guardamos el tier del mejor item
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = enemy.getEquipment().areThereAnyActives(list);
		int tierListEnemyItem = bestItemTier(list, ActionType.DEFENSIVE);
		int posBestActiveItem = bestItemPos(list, tierListEnemyItem, ActionType.OFFENSIVE);
		//Creamos una lista con los items del jugador (el target del ataque) y guardamos el tier del mejor item
		List<ActiveItemDecorator> listPlayer = new ArrayList<ActiveItemDecorator>(); 
		listPlayer = player.getEquipment().areThereAnyActives(listPlayer);
		int tierListPlayerItem = bestItemTier(listPlayer, ActionType.DEFENSIVE);
		
		//Calculamos la probabilidad
		int i = 0;
		// Este if compara el dano, mas el dano del mejor item del enemigo contra la defensa del jugador mas la defensa de su mejor item
		if(enemy.getEquipment().getAttack()+list.get(posBestActiveItem).getAttack() > player.getEquipment().getDefense() ) {
			i += 2;
		}
		// Comprobamos si el enemigo es capaz de matarlo en unos 3 turnos teniendo en cuenta los mismos datos que el if anterior
		if(enemy.getEquipment().getAttack()+list.get(posBestActiveItem).getAttack()*3 - player.getEquipment().getDefense() > 
		player.getEquipment().getLife()) {
			i+=3;
		}
		return i + tierListEnemyItem - tierListPlayerItem;
	}
	
	//Funcion que comprueba que tan "rentable" es defender
	protected int worthDefend(Enemy enemy, Player player) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = enemy.getEquipment().areThereAnyActives(list);
		int tierListEnemyItem = bestItemTier(list, ActionType.DEFENSIVE);
		int posBestActiveItem = bestItemPos(list, tierListEnemyItem, ActionType.DEFENSIVE);
		//Creamos una lista con los items del jugador (el target del ataque)
		List<ActiveItemDecorator> listPlayer = new ArrayList<ActiveItemDecorator>(); 
		listPlayer = player.getEquipment().areThereAnyActives(listPlayer);
		int tierListPlayerItem = bestItemTier(listPlayer, ActionType.DEFENSIVE);
		int i = 0;
		// Este if compara el dano, mas el dano del mejor item del enemigo contra la defensa del jugador mas la defensa de su mejor item
		if(enemy.getEquipment().getAttack()+list.get(posBestActiveItem).getDefense() > player.getEquipment().getDefense()) {
			i += 2;
		}
		// Comprobamos si el enemigo es capaz de matarlo en unos 3 turnos teniendo en cuenta los mismos datos que el if anterior
		if(player.getEquipment().getAttack() - player.getEquipment().getDefense()+list.get(posBestActiveItem).getDefense()*3 > 
		enemy.getEquipment().getLife()) {		
			i+=3;
		}
		return i + tierListEnemyItem - tierListPlayerItem;
	}
	
	protected int worthNeutral(Enemy enemy, Player player) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = enemy.getEquipment().areThereAnyActives(list);
		return bestItemTier(list, ActionType.NEUTRAL)/2;
	}
	
	// Esta funcion realiza una accion aleatoria ofensiva de entre los items ofensivos con mejor rango (tierList) que tenga
	private void attack(Enemy user, Player player, List<ActiveItemDecorator> skills) {
		//Obtenemos el mejor Tier de los items que tiene el jugador
		int bestTier = bestItemTier(skills, ActionType.OFFENSIVE);
		ArrayList<Integer>attacks = saveBestItems(bestTier, skills, ActionType.OFFENSIVE);
		int skill = selectItem(attacks,skills);
		skills.get(skill).useSkill(user, player);	
	}
	
	// Esta funcion realiza una accion aleatoria defensiva de entre los items ofensivos con mejor rango (tierList) que tenga
	private void defense(Enemy user, Player player, List<ActiveItemDecorator> skills) {
		int bestTier = bestItemTier(skills, ActionType.DEFENSIVE);
		ArrayList<Integer>defenses = saveBestItems(bestTier, skills, ActionType.DEFENSIVE);
		int skill = selectItem(defenses,skills);
		skills.get(skill).useSkill(user, player);	
	}
	
	public void neutral(Enemy user, Player player, List<ActiveItemDecorator> skills) {
		int bestTier = bestItemTier(skills, ActionType.NEUTRAL);
		ArrayList<Integer>neutrals = saveBestItems(bestTier, skills, ActionType.NEUTRAL);
		int skill = selectItem(neutrals,skills);
		skills.get(skill).useSkill(user, player);
	}
	
	// Esta funcion elige de que tipo va a ser la accion que va a realizar
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		int total = 0;
		for(int i =0; i < options.length; i++) {
			total += options[i];
		}
		int random = (int)Math.random()*(total+1);
		if(random < options[0]) {
			attack(user, target, skills);
		}else if(random < options[0] + options[1]) {
			defense(user, target, skills);
		}else {
			neutral(user, target,skills);
		}
	}
	
	// Esta funcion devuelve cual es el tier del objeto defensivo con mejor tier
	private int bestItemTier(List<ActiveItemDecorator> list, ActionType action) {
		int tierValue = 0;
		//Recorre la lista buscando el tier mas alto
		for(int i =0; i < list.size(); i++) {
			if(list.get(i).getActionType() == action) {
				if(list.get(i).getActionType().ordinal() > tierValue) {
					tierValue = list.get(i).getActionType().ordinal();
				}
			}
		}
		return tierValue;
	}
	
	private int selectItem(ArrayList<Integer>savedItems, List<ActiveItemDecorator> skills) {
		boolean correctAbilitySelected = false;
		int skill = 0;
		do {
			skill = (int)Math.random()*skills.size();
			for(int i =0; i < savedItems.size(); i++) {
				if(skill == savedItems.get(i)) {
					correctAbilitySelected = true;
				}
			}
		}while(correctAbilitySelected == false);
		return skill;
	}
	
	private ArrayList<Integer>saveBestItems(int bestTier, List<ActiveItemDecorator> skills, ActionType action){
		ArrayList<Integer>bestItems = new ArrayList<Integer>();
		for(int i =0; i < skills.size(); i++) {
			if(skills.get(i).getActionType() == action) {
				if(skills.get(i).getTier().ordinal() == bestTier) {
					bestItems.add(i);
				}
			}
		}
		return bestItems;
	}
	
	private int bestItemPos(List<ActiveItemDecorator> list, int bestItemTier, ActionType action) {
		int posBestActiveItem = 0;
		for(int i = 0; i < list.size(); i++) {
			//Comprobamos si alguno de los objetos es ofensivo
			if(list.get(i).getActionType() == ActionType.OFFENSIVE) {				
				//Despues comprobamos que el tier que es el item, siempre teniendo en cuenta que no haya ya uno tier s, en ese caso no hace falta
				if(list.get(i).getActionType().ordinal() == bestItemTier ) {
					posBestActiveItem = i;
				}	
			}
		}
		return posBestActiveItem;
	}
}

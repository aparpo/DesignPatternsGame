package strategyPattern.bossStrategies;

import java.util.ArrayList;
import java.util.List;

import base.*;
import decoratorPattern.*;
import strategyPattern.DecisionTemplate;

public class HardStrategy extends DecisionTemplate{

	//Funcion que comprueba que tan "rentable" es atacar
	protected int worthAttack(Enemy enemy, Player player) {
		int probability = 0;
		int tierListEnemyItem = 0;
		int posBestActiveItem = 0;
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = enemy.getEquipment().areThereAnyActives(list);
		// Con este for recorremos toda la lista de objetos activos
		for(int i = 0; i < list.size(); i++) {
			//Comprobamos si alguno de los objetos es ofensivo
			if(list.get(i).getActionType() == ActionType.OFFENSIVE) {
				
				//Comprobamos si tiene el mejor item del juego que hace dano en base a la vida del enemigo (100% de la vida), si lo tiene se devuelve 100(numero exageradamente alto)
				if(list.get(i).getName().equalsIgnoreCase("DeathSpear")) {
					probability = 100;
					return probability;
				}
				
				//Despues comprobamos que el tier que es el item, siempre teniendo en cuenta que no haya ya uno tier s, en ese caso no hace falta
				if(tierListEnemyItem < 3) {
					if(list.get(i).getTier() == Tier.S) {
						tierListEnemyItem = 3;
						posBestActiveItem = i;
					}else if(list.get(i).getTier() == Tier.A && tierListEnemyItem < 2) {
						tierListEnemyItem = 2;
						posBestActiveItem = i;
					}else if(list.get(i).getTier() == Tier.B && tierListEnemyItem < 1) {
						tierListEnemyItem = 1;
						posBestActiveItem = i;
					}
				}
				
			}
		}
		//Creamos una lista con los items del jugador (el target del ataque)
		List<ActiveItemDecorator> listPlayer = new ArrayList<ActiveItemDecorator>(); 
		listPlayer = player.getEquipment().areThereAnyActives(listPlayer);
		int tierListPlayerItem = 0;
		int extraDefensePlayer = 0 ;
		//Recorremos la lista
		for(int i = 0; i < list.size(); i++) {
			// Si tiene algun objeto defensivo
			if(listPlayer.get(i).getActionType() == ActionType.DEFENSIVE) {
				//Despues comprobamos que el tier que es el item, siempre teniendo en cuenta que no haya ya uno tier s, en ese caso no hace falta
				if(tierListPlayerItem < 3) {
					//Despues almacenamos la defensa del mejor objeto defensivo, dando por hecho que lo normal es que use lo mejor que tenga
					if(listPlayer.get(i).getTier() == Tier.S) {
						tierListPlayerItem = 2;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}else if(listPlayer.get(i).getTier() == Tier.A && tierListPlayerItem < 2) {
						tierListPlayerItem = 1;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}else if(listPlayer.get(i).getTier() == Tier.B && tierListPlayerItem < 1) {
						tierListPlayerItem = 0;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}else {
						tierListPlayerItem = -1;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}
				}
			}
				
		}

		int i = 0;
		// Este if compara el dano, mas el dano del mejor item del enemigo contra la defensa del jugador mas la defensa de su mejor item
		if(enemy.getEquipment().getAttack()+list.get(posBestActiveItem).getAttack() > player.getEquipment().getDefense() + extraDefensePlayer) {
			i += 2;
		}
		// Comprobamos si el enemigo es capaz de matarlo en unos 3 turnos teniendo en cuenta los mismos datos que el if anterior
		if(enemy.getEquipment().getAttack()+list.get(posBestActiveItem).getAttack()*3 - player.getEquipment().getDefense() + extraDefensePlayer > 
		player.getEquipment().getLife()) {
			
			i+=3;
		}
		
		return i + tierListEnemyItem - tierListEnemyItem;

	}
	
	//Funcion que comprueba que tan "rentable" es defender
	protected int worthDefend(Enemy enemy, Player player) {
		int probability = 0;
		int tierListEnemyItem = 0;
		int posBestActiveItem = -1;
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = enemy.getEquipment().areThereAnyActives(list);
		// Con este for recorremos toda la lista de objetos activos
		for(int i = 0; i < list.size(); i++) {
			//Comprobamos si alguno de los objetos es ofensivo
			if(list.get(i).getActionType() == ActionType.DEFENSIVE) {
			
				//Despues comprobamos que el tier que es el item, siempre teniendo en cuenta que no haya ya uno tier s, en ese caso no hace falta
				if(tierListEnemyItem < 3) {
					if(list.get(i).getTier() == Tier.S) {
						tierListEnemyItem = 3;
						posBestActiveItem = i;
					}else if(list.get(i).getTier() == Tier.A && tierListEnemyItem < 2) {
						tierListEnemyItem = 2;
						posBestActiveItem = i;
					}else if(list.get(i).getTier() == Tier.B && tierListEnemyItem < 1) {
						tierListEnemyItem = 1;
						posBestActiveItem = i;
					}
				}
				
			}
		}
		//Creamos una lista con los items del jugador (el target del ataque)
		List<ActiveItemDecorator> listPlayer = new ArrayList<ActiveItemDecorator>(); 
		listPlayer = player.getEquipment().areThereAnyActives(listPlayer);
		int tierListPlayerItem = 0;
		int extraAttackPlayer = 0 ;
		//Recorremos la lista
		for(int i = 0; i < list.size(); i++) {
			// Si tiene algun objeto defensivo
			if(listPlayer.get(i).getActionType() == ActionType.OFFENSIVE) {
				//Despues comprobamos que el tier que es el item, siempre teniendo en cuenta que no haya ya uno tier s, en ese caso no hace falta
				if(tierListPlayerItem < 3) {
					//Despues almacenamos la defensa del mejor objeto defensivo, dando por hecho que lo normal es que use lo mejor que tenga
					if(listPlayer.get(i).getTier() == Tier.S) {
						tierListPlayerItem = 2;
						extraAttackPlayer = listPlayer.get(i).getAttack();
					}else if(listPlayer.get(i).getTier() == Tier.A && tierListPlayerItem < 2) {
						tierListPlayerItem = 1;
						extraAttackPlayer = listPlayer.get(i).getAttack();
					}else if(listPlayer.get(i).getTier() == Tier.B && tierListPlayerItem < 1) {
						tierListPlayerItem = 0;
						extraAttackPlayer = listPlayer.get(i).getAttack();
					}else {
						tierListPlayerItem = -1;
						extraAttackPlayer = listPlayer.get(i).getAttack();
					}
				}
			}
				
		}

		int i = 0;
		// Este if compara el dano, mas el dano del mejor item del enemigo contra la defensa del jugador mas la defensa de su mejor item
		if(enemy.getEquipment().getAttack()+list.get(posBestActiveItem).getDefense() > player.getEquipment().getDefense() + extraAttackPlayer) {
			i += 2;
		}
		// Comprobamos si el enemigo es capaz de matarlo en unos 3 turnos teniendo en cuenta los mismos datos que el if anterior
		if(player.getEquipment().getAttack() + extraAttackPlayer - player.getEquipment().getDefense()+list.get(posBestActiveItem).getDefense()*3 > 
		enemy.getEquipment().getLife()) {
			
			i+=3;
		}
		
		return i + tierListEnemyItem - tierListPlayerItem;

	}
	
	protected int worthNeutral(Enemy enemy, Player player) {
		return 1;
	}
	
	// Esta funcion realiza una accion aleatoria ofensiva de entre los items ofensivos con mejor rango (tierList) que tenga
	public void attack(Enemy user, Player player, List<ActiveItemDecorator> skills) {
		ArrayList<Integer>attacks = new ArrayList<Integer>();
		boolean haveDeathStaff = false;
		//Obtenemos el mejor Tier de los items que tiene el jugador
		Tier bestTier = bestOffensiveItemTier(skills);
		//Recorremos el array buscando objetos ofensivos y del mejor tier
		for(int i =0; i < skills.size(); i++) {
			if(skills.get(i).getActionType() == ActionType.OFFENSIVE) {
				if(skills.get(i).getTier() == bestTier) {
					//Si tiene el death staff, al ser el mejor objeto ofensivo directamente usa eso
					if(skills.get(i).getName().equalsIgnoreCase("Death Staff")) {
						haveDeathStaff = true;
						attacks.add(0, i);
						break;
					}
					attacks.add(i);
				}
			}
		}
		//Si tiene el Death Staff que es el mejor item ofensivo lo usa directamente sino realiza una acion ofensiva
		if(haveDeathStaff) {
			skills.get(attacks.get(0)).useSkill(user, player);
		}else {
			boolean correctAbilitySelected = false;
			int skill;
			//Con este bucle nos aseguramos que la accion que se realiza sea una de las que se han almacenado como las mejores ofensivas
			do {
				skill = (int)Math.random()*skills.size();
				for(int i =0; i < attacks.size(); i++) {
					if(skill == attacks.get(i)) {
						correctAbilitySelected = true;
					}
				}
			}while(correctAbilitySelected == false);
			skills.get(skill).useSkill(user, player);
		}
		
	}
	
	// Esta funcion realiza una accion aleatoria defensiva de entre los items ofensivos con mejor rango (tierList) que tenga
	public void defense(Enemy user, Player player, List<ActiveItemDecorator> skills) {
		ArrayList<Integer>defenses = new ArrayList<Integer>();
		Tier bestTier = bestDefensiveItemTier(skills);
		for(int i =0; i < skills.size(); i++) {
			if(skills.get(i).getActionType() == ActionType.DEFENSIVE) {
				if(skills.get(i).getTier() == bestTier) {
					defenses.add(i);
				}
			}
		}
		boolean correctAbilitySelected = false;
		int skill;
		//Con este bucle nos aseguramos que la accion que se realiza sea una de las que se han almacenado como las mejores defensivas
		do {
			skill = (int)Math.random()*skills.size();
			for(int i =0; i < defenses.size(); i++) {
				if(skill == defenses.get(i)) {
					correctAbilitySelected = true;
				}
			}
		}while(correctAbilitySelected == false);
		skills.get(skill).useSkill(user, player);	
	}
	
	public void neutral(Enemy user, Player player) {
		
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
			neutral(user, target);
		}
		
	}

	
	// Esta funcion devuelve cual es el tier del objeto defensivo con mejor tier
	public Tier bestDefensiveItemTier(List<ActiveItemDecorator> list) {
		Tier tier = null;
		int tierValue = 0;
		//Recorre la lista buscando el tier mas alto
		for(int i =0; i < list.size(); i++) {
			if(list.get(i).getActionType() == ActionType.DEFENSIVE) {
				if(list.get(i).getTier() == Tier.S) {
					tier = Tier.S;
					break;
				}else if(list.get(i).getTier() == Tier.A && tierValue < 3) {
					tierValue =3;
					tier = Tier.A;
				}else if(list.get(i).getTier() == Tier.B && tierValue < 2) {
					tierValue =2;
					tier = Tier.B;
				}else if(list.get(i).getTier() == Tier.C && tierValue < 1) {
					tierValue =1;
					tier = Tier.C;
				}
			}
		}
		return tier;
	}
	
	// Esta funcion devuelve cual es el tier del objeto ofensivo con mejor tier
	public Tier bestOffensiveItemTier(List<ActiveItemDecorator> list) {
		Tier tier = null;
		int tierValue = 0;
		for(int i =0; i < list.size(); i++) {
			if(list.get(i).getActionType() == ActionType.OFFENSIVE) {
				if(list.get(i).getTier() == Tier.S) {
					tier = Tier.S;
					break;
				}else if(list.get(i).getTier() == Tier.A && tierValue < 3) {
					tierValue =3;
					tier = Tier.A;
				}else if(list.get(i).getTier() == Tier.B && tierValue < 2) {
					tierValue =2;
					tier = Tier.B;
				}else if(list.get(i).getTier() == Tier.C && tierValue < 1) {
					tierValue =1;
					tier = Tier.C;
				}
			}
		}
		return tier;
	}

}

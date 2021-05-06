package strategyPattern;

import java.util.ArrayList;
import java.util.List;

import base.ActionType;
import base.Character;
import base.Enemy;
import base.EquipmentTier;
import base.Player;
import decoratorPattern.ActiveItemDecorator;

public class HardStrategy extends DecisionTemplate implements StrategyTemplate{


	public int worthAttack(Character enemy, Character player) {
		int probability = -1;
		int tierListEnemyItem = 0;
		int posBestActiveItem = 0;
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = enemy.getEquipment().areThereAnyActives(list);
		// Con este for recorremos toda la lista de objetos activos
		for(int i = 0; i < list.size(); i++) {
			//Comprobamos si alguno de los objetos es ofensivo
			if(list.get(i).getActionType() == ActionType.OFFENSIVE) {
				//Si lo es ponemos probability a 0, en caso de que esta no se modifique a 0 despues de recorrer la lista entera, devolvera 0 psobilidades de atacar
				probability = 0;
				
				//Comprobamos si tiene el mejor item del juego que hace dano en base a la vida del enemigo (100% de la vida), si lo tiene se devuelve 100(numero exageradamente alto)
				if(list.get(i).getName().equalsIgnoreCase("DeathSpear")) {
					probability = 100;
					return probability;
				}
				
				//Despues comprobamos que el tier que es el item, siempre teniendo en cuenta que no haya ya uno tier s, en ese caso no hace falta
				if(tierListEnemyItem < 3) {
					if(list.get(i).getEquipmentTier() == EquipmentTier.S) {
						tierListEnemyItem = 3;
						posBestActiveItem = i;
					}else if(list.get(i).getEquipmentTier() == EquipmentTier.A && tierListEnemyItem < 2) {
						tierListEnemyItem = 2;
						posBestActiveItem = i;
					}else if(list.get(i).getEquipmentTier() == EquipmentTier.B && tierListEnemyItem < 1) {
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
				if(tierListEnemyItem < 3) {
					//Despues almacenamos la defensa del mejor objeto defensivo, dando por hecho que lo normal es que use lo mejor que tenga
					if(listPlayer.get(i).getEquipmentTier() == EquipmentTier.S) {
						tierListEnemyItem = 2;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}else if(listPlayer.get(i).getEquipmentTier() == EquipmentTier.A && tierListEnemyItem < 2) {
						tierListEnemyItem = 1;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}else if(listPlayer.get(i).getEquipmentTier() == EquipmentTier.B && tierListEnemyItem < 1) {
						tierListEnemyItem = 0;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}else {
						tierListEnemyItem = -1;
						extraDefensePlayer = listPlayer.get(i).getDefense();
					}
				}
			}
				
		}
		
		if(probability == -1) {
			return 0;
		}else {
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
	}
	public int worthDefense(Character enemy, Character player) {
		return 0;
	}
	public void attack(Enemy user, Character player) {
		
	}
	public void defense(Enemy user, Character player) {
		
	}
	public void neutral(Character user, Character player) {
		
	}
	protected int worthAttack() {
		return 0;
	}
	protected int worthDeffend() {

		return 0;
	}
	protected int worthNeutral() {
		return 0;
	}
	protected void selectSkill(int[] options, List<ActiveItemDecorator> skills, Enemy user, Player target) {
		
		
	}
	
	public int objectType(ActionType style, Character user) {
		List<ActiveItemDecorator> list = new ArrayList<ActiveItemDecorator>(); 
		list = user.getEquipment().areThereAnyActives(list);
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getActionType() == style) {
				return 0;
			}
		}
		return -1;
	}
}

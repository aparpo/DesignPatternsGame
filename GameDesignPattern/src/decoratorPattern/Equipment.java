package decoratorPattern;

import java.util.List;

import base.Stats;

public class Equipment implements Item{ //Componente base
	private Stats stats;
	
	public Equipment() {
		setStats(new Stats(0,0,0,0,0));
	}
	
	public void applyStats(Stats variation) { //Aplicar una variacion de estadisticas
		stats.applyStats(variation);
	}
	
	public void backToNormal() { //Devolver al estado basico todas las estadisticas menos la vida actual
		stats.backToNormal();
	}
	
	@Override
	public Item addItem(ItemDecorator newItem) {
		newItem.setEquipment(this);
		return newItem;
	}
	
	public Item isThereAny(Item model){
		return null; //Se ha llegado al final y no se ha encontrado un model
		
	}

	public List<ActiveItemDecorator> areThereAnyActives(List<ActiveItemDecorator> list){
		return list; //Se ha llegado al final y se devuelve la lista de los encontrados
	}

	public List<PassiveItemDecorator> areThereAnyPassives(List<PassiveItemDecorator> list){
		return list; //Se ha llegado al final y se devuelve la lista de los encontrados
	}
	
	public int getLife() {
		return stats.getLife();
	}
	public void setLife(int life) {
		stats.setLife(life);
	}
	public int getMaxLife() {
		return stats.getMaxLife();
	}
	public void setMaxLife(int maxLife) {
		stats.setMaxLife(maxLife);
	}
	public int getAttack() {
		return stats.getAttack();
	}
	public void setAttack(int attack) {
		stats.setAttack(attack);;
	}
	public int getDefense() {
		return stats.getDefense();
	}
	public void setDefense(int defense) {
		stats.setDefense(defense);;
	}
	public int getSpeed() {
		return stats.getSpeed();
	}
	public void setSpeed(int speed) {
		stats.setSpeed(speed);;
	}

	@Override
	public Tier getTier() {
		return null;
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}
	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

}
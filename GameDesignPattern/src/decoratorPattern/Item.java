package decoratorPattern;

import java.util.List;

import base.Stats;

public interface Item { //Interfaz general 
	
	public int getLife();
	public void setLife(int life);
	public int getMaxLife();
	public int getAttack();
	public int getDefense();
	public int getSpeed();
	public String getDesc();
	public Tier getTier();
	
	public void applyStats(Stats variation); //Suma de estadisticas
	public void backToNormal(); //Valores por defecto
	
	public Item isThereAny(Item model);
	public List<ActiveItemDecorator> areThereAnyActives(List<ActiveItemDecorator> list);
	public List<PassiveItemDecorator> areThereAnyPassives(List<PassiveItemDecorator> list);
}

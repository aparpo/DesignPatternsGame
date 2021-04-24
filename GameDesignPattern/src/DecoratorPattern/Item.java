package DecoratorPattern;

import java.util.List;

public interface Item {
	public int getLife();
	public void setLife(int life);
	public int getMaxLife();
	public int getAttack();
	public int getDefense();
	public int getSpeed();
	public String getDesc();
	
	//public <T extends Item> List<T> isThereAny(List<T> list);
}

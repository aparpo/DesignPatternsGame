package abstractFactoryPattern.enemies;
import abstractFactoryPattern.Enemy;
import decoratorPattern.ActiveItemDecorator;
import decoratorPattern.Stats;

public class DarkwraithKnight extends Enemy{
	protected String magicUsed;

	public DarkwraithKnight(String name, Stats stats, ActiveItemDecorator weapon, String magicUsed) {
		super(name, stats, weapon);
		this.magicUsed = magicUsed;
	}

	public String getUsedMagic() {
		return magicUsed;
	}

	public void setUsedMagic(String usedMagic) {
		this.magicUsed = usedMagic;
	}
	
}

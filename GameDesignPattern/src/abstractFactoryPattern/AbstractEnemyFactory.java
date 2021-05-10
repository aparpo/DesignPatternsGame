package abstractFactoryPattern;

import base.Enemy;

public interface AbstractEnemyFactory {
	public Enemy createHollow();
	public Enemy createSkeleton();
	public Enemy createStoneGuardin();
	public Enemy createCapraDemon();
	public Enemy createBlackKnight();
	public Enemy createDarkwraithKnight();
	public Enemy createRandomEnemy();
}

package abstractFactoryPattern;

import base.Enemy;

public interface AbstractEnemyFactory {
	public Enemy createHollow();
	public Enemy createSkeleton();
	public Enemy createGiant();
	public Enemy createCapraDemon();
	public Enemy createBlackKnight();
	public Enemy createCrysal();
	public Enemy generateEnemy();
}

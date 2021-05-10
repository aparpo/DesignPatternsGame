package abstractFactoryPattern;

public enum World {
	WORLD1(1.0), WORLD2(1.2), WORLD3(1.4), WORLD4(1.6), WORLD5(1.8), BOSS(2.0);
	
	private double complexFactor;
	public double getComplexFactor() {
		return complexFactor;
	}
	
	private World(double complexFactor) {
		this.complexFactor = complexFactor;
	}
}

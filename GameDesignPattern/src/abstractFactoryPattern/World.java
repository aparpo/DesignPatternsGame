package abstractFactoryPattern;

public enum World {
	WORLD1(1), WORLD2(2), WORLD3(3), WORLD4(4), WORLD5(5), BOSS(10);
	
	private Integer complexFactor;
	public Integer getComplexFactor() {
		return complexFactor;
	}
	
	private World(Integer complexFactor) {
		this.complexFactor = complexFactor;
	}
}

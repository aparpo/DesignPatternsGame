package abstractFactoryPattern;

public enum World {
	LEVEL1(1), LEVEL2(2), LEVEL3(3), LEVEL4(4), LEVEL5(5), BOSS(10);
	
	private Integer complexFactor;
	public Integer getComplexFactor() {
		return complexFactor;
	}
	private World(Integer complexFactor) {
		this.complexFactor = complexFactor;
	}
}

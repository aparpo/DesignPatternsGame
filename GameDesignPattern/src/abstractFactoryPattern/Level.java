package abstractFactoryPattern;

public enum Level {
	LEVEL1(1), LEVEL2(2), LEVEL3(3), LEVEL4(4), LEVEL5(5), BOSS(10);
	
	private Integer complexFactor;
	public Integer getComplexFactor() {
		return complexFactor;
	}
	private Level(Integer complexFactor) {
		this.complexFactor = complexFactor;
	}
}

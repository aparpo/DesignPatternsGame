package statePattern;

public enum States {	
	STANDARD("Normal"), CONFUSED("Confundido"), FURIOUS("Furioso"), PARALYZED("Paralizado"),
	SERIOUSLYPARALYZED("Gravemente paralizado"), POISONED("Envenendado"), SERIOUSLYPOISONED("Gravemente envenedado");
	
	private String desc;
	
	private States(String desc) {
		this.setDesc(desc);
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}

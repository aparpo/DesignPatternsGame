package strategyPattern;

public class FightContext {
	private BehaviourStrategy behaviourStrategy;

	public FightContext() {}

	public FightContext(BehaviourStrategy behaviourStrategy) {
		this.behaviourStrategy = behaviourStrategy;
	}

	public BehaviourStrategy getBehaviourStrategy() {
		return behaviourStrategy;
	}

	public void setBehaviourStrategy(BehaviourStrategy behaviourStrategy) {
		this.behaviourStrategy = behaviourStrategy;
	}
	
	public void applyStrategy() {
		this.behaviourStrategy.doAction();
	}
	
}

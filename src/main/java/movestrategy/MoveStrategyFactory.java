package movestrategy;

public enum MoveStrategyFactory {
    SINGLETON;

    public MoveStrategy produceStrategy(String strategyName) throws IllegalArgumentException {
        switch (strategyName) {
            case "run":
                return new Run();
            case "fly":
                return new Fly();
            case "espurr":
                return new Espurr();
            default:
                throw new IllegalArgumentException();
        }
    }
}

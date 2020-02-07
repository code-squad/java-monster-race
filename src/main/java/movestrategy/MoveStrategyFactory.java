package movestrategy;

public enum MoveStrategyFactory {
    SINGLETON;

    public MoveStrategy produceStrategy(String strategyName) throws IllegalArgumentException {
        switch (strategyName) {
            case "RUN":
                return new Run();
            case "FLY":
                return new Fly();
            case "ESPURR":
                return new Espurr();
            default:
                throw new IllegalArgumentException();
        }
    }
}

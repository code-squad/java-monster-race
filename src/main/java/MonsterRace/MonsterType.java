package MonsterRace;

public enum MonsterType {
  달리기(new Run()),
  비행(new Fly()),
  에스퍼(new Esper());

  private MoveBehavior moveBehavior;

  MonsterType(MoveBehavior moveBehavior) {
    this.moveBehavior = moveBehavior;
  }

  public MoveBehavior getMoveBehavior() {
    return moveBehavior;
  }
}

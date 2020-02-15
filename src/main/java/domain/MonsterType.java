package domain;

public enum MonsterType {

  RUNNING("running"),
  FLYING("flying"),
  PSYCHIC("psychic");

  private final String name;

  MonsterType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}

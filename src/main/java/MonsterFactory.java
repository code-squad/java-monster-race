public class MonsterFactory {
    public static Monster getMonsterInstance(String monsterName, String typeName) {
        switch (typeName) {
            case "노말" :
                return new Normal(monsterName, TYPE.NORMAL);
            case "비행" :
                return new Flying(monsterName, TYPE.FLYING);
            case "에스퍼" :
                return new Psychic(monsterName, TYPE.PSYCHIC);
        }
        return null;
    }
}
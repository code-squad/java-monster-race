public class GameMachine {

    public static void main(String[] args) {

        Input.opening();
        int countOfMonsters = Input.getCountOfMosters();
        int rounds = Input.getRounds();

        MonsterRace race = new MonsterRace(countOfMonsters, rounds);
        race.startRace();
    }
}

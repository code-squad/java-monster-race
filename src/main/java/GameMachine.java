public class GameMachine {

    public static void main(String[] args) {

        System.out.println("<스릴만점 건전한 몬스터 경주>");
        Input input = new Input();
        int countOfMonsters = input.getCountOfMonsters();
        int rounds = input.getRounds();

        MonsterRace race = new MonsterRace(countOfMonsters, rounds);
        race.start();

        input.closeScanner();
    }
}

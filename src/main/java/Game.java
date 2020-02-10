public class Game {

    public void play() {
        Preparation prep = new Preparation();
        prep.getNumberOfMonsters();
        prep.getNameAndTypeOfMonsters();
        prep.getNumberOfTries();

        MonsterType mt = new MonsterType(prep.numberOfTries());
        mt.matchAllType(prep.monsterList());


        Result result = new Result();
        result.printAllMonsterLocation(prep.monsterList());
        end();
        result.printWinner(prep.monsterList());
    }

    public void end() {
        System.out.println("- Race Over - ");
    }
}
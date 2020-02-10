public class Game {

    public void play() {
        RacePreparation prep = new RacePreparation();
        prep.getNumberOfMonsters();
        prep.getNameAndTypeOfMonsters();
        prep.getNumberOfTries();

        RaceContest raceContest = new RaceContest(prep.numberOfTries());
        raceContest.matchAllType(prep.monsterList());

        RaceResult result = new RaceResult();
        result.printAllMonsterLocation(prep.monsterList());
        end();
        result.printWinner(prep.monsterList());
    }

    public void end() {
        System.out.println("- Race Over - ");
    }
}
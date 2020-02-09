public class Game {

    public void play() {
        Preparation prep = new Preparation();
        prep.getNumberOfMonsters();
        prep.getNameAndTypeOfMonsters();
        prep.getNumberOfTries();
//        prep.makePlayerList();

        Movement movement = new Movement(prep.numOfMonster, prep.numOfTries, prep.getPlayerList());
        movement.moveAllMonstersFullTime(prep.getPlayerList());

        Result result = new Result();
        result.printAllMonsterLocation(prep.getPlayerList());
        end();
    }

    public void end() {
        System.out.println("- Game Over - ");
    }
}
public class Game {

    public void play() {
        Preparation prep = new Preparation();
        prep.getNumberOfMonsters();
        prep.getNameAndTypeOfMonsters();
        prep.getNumberOfTries();

        MonsterType mt = new MonsterType(prep.getNumOfTries());
        mt.matchAllType(prep.getPlayerList());


//        Movement movement = new Movement(prep.getNumOfMonster(), prep.getNumOfTries(), prep.getPlayerList());
//        movement.moveAllMonstersFullTime(prep.getPlayerList());

        Result result = new Result();
        result.printAllMonsterLocation(prep.getPlayerList());
        end();
        for(Monster m : prep.getPlayerList()) {
            System.out.println(m.getName() + " : " + m.getMoves() + " : " + m.getType());
        }
    }

    public void end() {
        System.out.println("- Game Over - ");
    }
}
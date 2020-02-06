public class GameMachine {

    public static void run(){
        MonsterRace race = new MonsterRace();
        if(race.readyRace())
            race.startRace();
    }

    public static void close(){
        ConsoleIO.close();
    }

    public static void main(String[] args) {
        run();
        close();
    }
}

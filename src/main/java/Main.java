public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        RaceInitializer raceInitializer = new RaceInitializer();

        raceInitializer.initializeRace(race);
        race.start();
    }
}

public class Main {
    public static void main(String[] args) {
        InputHandler in = new InputHandler();
        int numMonster = in.readNumMonster();
        int numRound = in.readNumRound();

        Playground pg = new Playground(numMonster, numRound);
        pg.playGame();
    }
}

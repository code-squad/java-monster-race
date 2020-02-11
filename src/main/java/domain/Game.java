package domain;

import util.Message;

public class Game {

    private Monsters monsters;
    private Message message;

    public Game() {
        message = new Message();
        monsters = new Monsters();
    }

    public Monsters readyGame() {
        return monsters;
    }

    public void startGame(Monsters monsters) {
        message.printResultMessage();
        printMonsterForward(monsters);
    }

    public void closeGame(Monsters monsters) {
        printWinner(monsters);
        message.printCloseMessage();
    }

    private void printMonsterForward(Monsters monsters) {
        monsters.printMonstersForward();
    }

    private void printWinner(Monsters monsters) {
        message.printCelebrationMessage(monsters.getWinner());
    }
}

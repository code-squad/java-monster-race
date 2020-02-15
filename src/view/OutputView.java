package view;

import model.Monster;
import util.Message;
import java.util.Comparator;
import java.util.Optional;
import static controller.Controller.*;

public class OutputView {

    public void result() {
        printRaceResult();
        printWinner();
    }

    private void printRaceResult() {
        System.out.println(Message.raceStartMessage);
        for (Monster monster : monsterList) {
            System.out.println(monster.toString());
        }
    }

    private void printWinner() {
        Optional<Monster> optionalMonster = monsterList.stream().max(Comparator.comparing(Monster::getDistance));
        if(optionalMonster.isPresent()){
            String winner = optionalMonster.get().getName();
            System.out.printf(Message.congratulations, winner);
        }
    }
}

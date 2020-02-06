import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonsterRace {

    private int rounds;
    private List<Monster> monsterList = new ArrayList<>();

    public boolean readyRace(){
        ConsoleIO.printLine("<스릴만점 건전한 몬스터 경주>");
        setMonsters();
        setRounds();

        if(verifyRaceCondition())
            return true;

        return false;
    }

    public void startRace(){
        ConsoleIO.printLine("<레이스 시작!>");

        for(int i = 1; i <= this.rounds; ++i){
            ConsoleIO.printLine("<" + i + "회>");
            updateRound();
        }
    }

    private void setMonsters(){
        int countOfMonsters = ConsoleIO.printLineReturnInt("출전할 몬스터는 몇 마리?");
        initMonster(countOfMonsters);
    }

    private void initMonster(int countOfMonster){
        for(int i = 0; i < countOfMonster; ++i)
            monsterList.add(new Monster());
    }

    private void setRounds(){
        this.rounds = ConsoleIO.printLineReturnInt("몇 라운드?");
    }

    private boolean verifyRaceCondition(){
        return monsterList.size() > 0 && this.rounds > 0;
    }

    private void updateRound(){
        for(Monster monster : monsterList){
            monster.update();
            monster.render();
        }
    }
}

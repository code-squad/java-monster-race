import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonsterRace {

    private int rounds;
    private List<Monster> monsterList = new ArrayList<>();

    private void readyRace(){
        ConsoleIO.printLine("<스릴 만점 건전한 몬스터 경주>");
        setMonsters();
        setRounds();
    }

    private void setMonsters(){
        ConsoleIO.printLine("출전할 몬스터는 몇 마리?");
        int countOfMonster = ConsoleIO.getInputDataByInt();
        initMonster(countOfMonster);
    }

    private void initMonster(int countOfMonster){
        for(int i = 0; i < countOfMonster; ++i)
            monsterList.add(new Monster());
    }

    private void setRounds(){
        ConsoleIO.printLine("라운드 수?");
        this.rounds = ConsoleIO.getInputDataByInt();
    }

    private void startRace(){
        ConsoleIO.printLine("<레이스 시작!>");

        for(int i = 1; i <= this.rounds; ++i){
            ConsoleIO.printLine("<" + i + "회>");
            updateRound();
        }
    }

    private void updateRound(){
        for(Monster monster : monsterList){
            monster.update();
            monster.render();
        }
    }

    public static void main(String[] args) {
        MonsterRace race = new MonsterRace();
        race.readyRace();
        race.startRace();
        ConsoleIO.close();
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MonsterRace {

    private int rounds;
    private List<Monster> monsterList = new ArrayList<>();

    private void readyRace(){
        System.out.println("<스릴 만점 건전한 몬스터 경주>");
        System.out.println("출전할 몬스터는 몇 마리?");

        int countOfMonster = getInputDataByInt();
        initMonster(countOfMonster);

        System.out.println("라운드 수?");
        this.rounds = getInputDataByInt();
    }

    private int getInputDataByInt(){
        int result;
        Scanner scanner = new Scanner(System.in);
        try{
            result = Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException e){
            result = 0;
        }
        return result;



    }

    private void initMonster(int countOfMonster){
        for(int i = 0; i < countOfMonster; ++i)
            monsterList.add(new Monster());
    }

    private void startRace(){
        System.out.println("<레이스 시작!>");

        for(int i = 1; i <= this.rounds; ++i){
            System.out.println("<" + i + "회>");
            updateRounds();
        }
    }

    private void updateRounds(){
        for(Monster monster : monsterList){
            monster.update();
            monster.print();
        }
    }

    public static void main(String[] args) {
        MonsterRace race = new MonsterRace();
        race.readyRace();
        race.startRace();
    }
}

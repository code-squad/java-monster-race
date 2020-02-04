package kyungrae;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameManager {
    static GameManager instance;

    static Scanner sc;
    List<Monster> monsterList;
    int nRound;

    private GameManager(){
        sc = new Scanner(System.in);
        monsterList = new ArrayList<>();
    }

    public static GameManager getGameManager(){
        if(instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void build() {
        setMonsters();
        setRound();
    }

    public void start(){
        System.out.println("\n<경기 시작>\n");
        for(int i=0; i<nRound; i++){
            playARound();
        }
    }

    public void printResult(){
        Monster firstMonster = monsterList.get(0);

        for(Monster monster: monsterList){
            System.out.println(monster);
            if(firstMonster.distance < monster.distance)
                firstMonster = monster;
        }

        System.out.println("\n축하합니다.! " + firstMonster.name + "가 몬스터 레이스에서 우승했습니다.");
    }

    private void setMonsters() {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        int monsterCount = Integer.parseInt(sc.nextLine());

        System.out.println("\n경주할 몬스터 이름과 종류를 입력하세요(쉼표(,)를 기준으로 구분).");
        for(int i=0; i<monsterCount; i++) {
            String[] tokens = sc.nextLine().trim().split(",");
            Monster monster = createMonster(tokens);
            monsterList.add(monster);
        }
    }

    private Monster createMonster(String[] tokens){
        Monster monster = null;
        switch (tokens[1]){
            case "달리기":
                monster = new Runner(tokens[0], tokens[1]);
                break;
            case "비행":
                monster = new Flyer(tokens[0], tokens[1]);
                break;
            case "에스퍼":
                monster = new Esper(tokens[0], tokens[1]);
                break;
        }

        return monster;
    }

    private void setRound(){
        System.out.println("\n시도할 횟수는 몇회인가요?");
        nRound = Integer.parseInt(sc.nextLine());
    }

    private void playARound() {
        for(Monster monster: monsterList) {
            monster.playARound();
        }
    }
}

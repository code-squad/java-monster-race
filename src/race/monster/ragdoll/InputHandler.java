package race.monster.ragdoll;

import java.util.Scanner;

public class InputHandler {
    private int inputNumOfMonsters;
    private int inputNumOfTries;
    private String nameOfMonster;
    private String typeOfMonster;

    Scanner scanner = new Scanner(System.in);

    public InputHandler() {}

    public void setNumOfMonsters() {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        inputNumOfMonsters = Integer.parseInt(scanner.nextLine());
    }

    public int getNumOfMonsters() {
        return inputNumOfMonsters;
    }

    public void setMonsterProperties() {
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요. (종류 - '달리기', '비행', '에스퍼'");
        String inputText = scanner.nextLine();

        String blankDeletedText = inputText.replaceAll(" ", "");
        String[] information = blankDeletedText.split(",");

        nameOfMonster = information[0];
        typeOfMonster = information[1];
    }

    public String getNameOfMonster() {
        return nameOfMonster;
    }

    public String getTypeOfMonster() {
        return typeOfMonster;
    }

    public void setNumOfTries() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        inputNumOfTries = Integer.parseInt(scanner.nextLine());
    }

    public int getNumOfTries() {
        return inputNumOfTries;
    }

}

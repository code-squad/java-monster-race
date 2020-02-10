package race.monster.ragdoll;

import java.io.IOException;
import java.util.Scanner;

public class InputHandler {
    private String inputNameOfMonster;
    private Types inputTypeOfMonster;

    Scanner scanner = new Scanner(System.in);

    public InputHandler() {
    }

    int setNumOfMonsters() throws IOException {
        System.out.println("<스릴만점 건전한 몬스터 경주>");
        System.out.println("몬스터는 모두 몇 마리인가요?");
        int inputNumOfMonsters = Integer.parseInt(scanner.nextLine());

        if (inputNumOfMonsters < 0) {
            throw new IOException("음수가 입력 되었습니다.");
        }

        return inputNumOfMonsters;
    }

    private String[] splitProperty() {
        String inputText = scanner.nextLine();
        String blankDeletedText = inputText.replaceAll(" ", "");

        return blankDeletedText.split(",");
    }

    void setMonsterProperties() {
        final String RUNNER = "달리기", FLYING = "비행", ESPER = "에스퍼";
        String[] properties = splitProperty();

        inputNameOfMonster = properties[0];
        String typeNameOfMonster = properties[1];

        switch (typeNameOfMonster) {
            case RUNNER:
                inputTypeOfMonster = Types.RUNNER;
                break;
            case FLYING:
                inputTypeOfMonster = Types.FLYING;
                break;
            case ESPER:
                inputTypeOfMonster = Types.ESPER;
                break;
            default:
                throw new IllegalArgumentException("잘못된 타입이 입력 되었습니다.");
        }
    }

    public String getNameOfMonster() {
        return inputNameOfMonster;
    }

    public Types getTypeOfMonster() {
        return inputTypeOfMonster;
    }

    int setNumOfTries() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int inputNumOfTries = Integer.parseInt(scanner.nextLine());

        return inputNumOfTries;
    }
}

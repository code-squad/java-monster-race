package race.monster.ragdoll;

import java.io.IOException;
import java.util.Scanner;

public class InputHandler {
    private String inputNameOfMonster;
    private Types inputTypeOfMonster;

    private Scanner scanner = new Scanner(System.in);

    int setNumOfMonsters() {
        try {
            System.out.println("<스릴만점 건전한 몬스터 경주>");
            System.out.println("몬스터는 모두 몇 마리인가요?");
            int inputNumOfMonsters = Integer.parseInt(scanner.nextLine());

            if (inputNumOfMonsters <= 0) {
                throw new IOException("자연수가 입력되지 않았습니다..");
            }

            return inputNumOfMonsters;
        } catch (IOException | NumberFormatException e) {
            System.out.println("자연수를 입력 해주세요.");
            return setNumOfMonsters();
        }
    }

    private String[] splitProperties() {
        String inputText = scanner.nextLine();
        String blankDeletedText = inputText.replaceAll(" ", "");

        return blankDeletedText.split(",");
    }

    void setMonsterProperties() {
        try {
            final String RUNNER = "달리기", FLYING = "비행", ESPER = "에스퍼";
            String[] properties = splitProperties();

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
        } catch (IllegalArgumentException e) {
            System.out.println("'달리기', '비행', '에스퍼'중 한가지 타입을 입력 해주세요.");
            setMonsterProperties();
        }
    }

    public String getNameOfMonster() {
        return inputNameOfMonster;
    }

    public Types getTypeOfMonster() {
        return inputTypeOfMonster;
    }

    int setNumOfTries() {
        try {
            System.out.println("시도할 회수는 몇 회 인가요?");
            int inputNumOfTries = Integer.parseInt(scanner.nextLine());

            if (inputNumOfTries <= 0) {
                throw new IOException("자연수가 입력되지 않았습니다.");
            }
            return inputNumOfTries;
        } catch (IOException e) {
            System.out.println("자연수를 입력 해주세요.");
            return setNumOfTries();
        }

    }
}

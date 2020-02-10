import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public int getCountOfMonsters() {
        System.out.println("출전할 몬스터는 몇 마리?");
        return getPositiveInt();
    }

    public List<Monster> getParticipants(int countOfMonsters) {
        System.out.println("경주할 몬스터 이름과 종류를 입력하세요. (쉼표(,)를 기준으로 구분)");
        Monster[] monsters = new Monster[countOfMonsters];
        for(int i = 0; i < monsters.length; i++) {
            try {
                monsters[i] = createMonster();
            } catch(InvalidDelimiterException | UnknownMonsterTypeException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }
        return Arrays.asList(monsters);
    }

    public int getRounds() {
        System.out.println("몇 라운드?");
        return getPositiveInt();
    }

    public void closeScanner() {
        if(scanner != null)
            scanner.close();
    }

    private int getPositiveInt() {
        int input;
        try {
            input = Integer.parseInt(scanner.nextLine());
            if(input <= 0)
                throw new InvalidRangeException("유효 범위에서 벗어난 입력값입니다.");
        } catch(NumberFormatException | InvalidRangeException e) {
            System.out.println(e.getMessage());
            input = getPositiveInt();
        }
        return input;
    }

    private Monster createMonster() throws InvalidDelimiterException, UnknownMonsterTypeException {
        final int INDEX_NAME = 0;
        final int INDEX_TYPE = 1;

        String[] monsterInfo = getMonsterInfo();
        if(monsterInfo.length <= INDEX_TYPE)
            throw new InvalidDelimiterException("잘못된 구분자입니다.");

        Monster monster = MonsterFactory.getMonsterInstance(monsterInfo[INDEX_NAME], monsterInfo[INDEX_TYPE]);
        if(monster == null)
            throw new UnknownMonsterTypeException("존재하지 않는 몬스터 타입입니다.");
        return monster;
    }

    private String[] getMonsterInfo() {
        String input = scanner.nextLine().replaceAll(" ", "");
        return input.split(",");
    }

    private static class InvalidRangeException extends RuntimeException {

        public InvalidRangeException(String message) {
            super(message);
        }
    }

    private static class InvalidDelimiterException extends RuntimeException {

        public InvalidDelimiterException(String message) {
            super(message);
        }
    }

    private static class UnknownMonsterTypeException extends RuntimeException {

        public UnknownMonsterTypeException(String message) {
            super(message);
        }
    }
}

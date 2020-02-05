import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    BufferedReader input;

    public InputHandler() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public int getMonsterNumber() {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        int monsterNumber = 0;
        try {
            monsterNumber = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return monsterNumber;
    }

    public int getTryNumber() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryNumber = 0;
        try {
            tryNumber = Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tryNumber;
    }
}

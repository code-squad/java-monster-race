import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    BufferedReader bufferedReader;

    public InputView() {
        bufferedReader = new BufferedReader(new
                InputStreamReader(System.in));
    }

    public int monsterNumber() throws IOException {
        System.out.println("몬스터는 모두 몇 마리인가요?");
        return Integer.parseInt(bufferedReader.readLine());

    }

    public int tryNumber() throws IOException {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void close() throws IOException {
        bufferedReader.close();
    }

}

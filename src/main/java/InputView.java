import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    BufferedReader bufferedReader;

    public InputView() {
        bufferedReader = new BufferedReader(new
                InputStreamReader(System.in));
    }

    public String[] monsterInfo() throws IOException {
        String[] result = new String[2];

        System.out.println("경주할 몬스터 이름과 종류를 입력하세요 (쉼표(,)를 기준으로 구분).");
        String input = bufferedReader.readLine();

        input = input.replaceAll("\\s+", "");
        result[0] = input.split(",")[0];
        result[1] = input.split(",")[1];
        return result;
    }

    public int monsterNumber() throws IOException {
        System.out.println("몇 명의 몬스터가 경주하나요?");
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

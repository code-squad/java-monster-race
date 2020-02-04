import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    private BufferedReader in;

    public InputHandler() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readNumMonster() {
        System.out.println("Number of monsters?");
        return readInt();
    }

    public int readNumRound() {
        System.out.println("Number of rounds?");
        return readInt();
    }

    private int readInt() {
        try {
            int returnValue = Integer.parseInt(in.readLine());
            if (returnValue <= 0) { throw new InvalidRangeException(); }
            return returnValue;
        } catch (NumberFormatException | InvalidRangeException e) {
            System.out.println("Must be a positive integer.");
            return readInt();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static class InvalidRangeException extends Exception {}
}

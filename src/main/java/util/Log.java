package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private static Log log = null;
    private static BufferedWriter bw;
    private Time time;

    private Log() {
        try {
            time = new Time();
            bw = new BufferedWriter(new FileWriter("monstersInfo : " + time.getCurrentTime() + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Log getInstance() {
        if (log == null) log = new Log();
        return log;
    }

    public void write(String input) {
        try {
            bw.write(input + "\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void finalize() {
        try {
            super.finalize();
            bw.close();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}

package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Log {
    private static Log log = new Log();
    private static BufferedWriter bw;
    private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private Log() {
        try {
            bw = new BufferedWriter(new FileWriter("monsterInfo : " + getCurrentTime() + ".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Log getInstance() {
        return log;
    }

    public synchronized void write(String input) {
        try {
            bw.write(input + "\n");
            bw.flush();
        } catch (IOException e) {
        }
    }

    private String getCurrentTime() {
        return format.format(System.currentTimeMillis());
    }

    @Override
    protected void finalize() {
        try {
            super.finalize();
            bw.close();
        } catch (Throwable throwable) {
        }

    }
}

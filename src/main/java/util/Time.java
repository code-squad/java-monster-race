package util;

import java.text.SimpleDateFormat;

public class Time {
    private SimpleDateFormat format;

    public Time() {
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public String getCurrentTime() {
        return format.format(System.currentTimeMillis());
    }
}

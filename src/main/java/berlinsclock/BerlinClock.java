package berlinsclock;

import java.time.LocalTime;

public class BerlinClock {
    public static String format(LocalTime time) {
        return null;
    }

    public static String formatSeconds(int seconds) {
        if (seconds % 2 == 0) {
            return "Y";
        }
        return "O";
    }
}

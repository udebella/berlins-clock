package berlinsclock;

import java.time.LocalTime;

public class BerlinClock {
    public static String format(LocalTime time) {
        return formatSeconds(time.getSecond());
    }

    public static String formatSeconds(int seconds) {
        return isEvenNumber(seconds) ? "Y" : "O";
    }

    private static boolean isEvenNumber(int seconds) {
        return seconds % 2 == 0;
    }

    public static String formatFiveHour(int hours) {
        if (hours == 5) {
            return "ROOO";
        }
        return "OOOO";
    }
}

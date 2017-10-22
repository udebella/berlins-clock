package berlinsclock;

import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock {
    public static String format(LocalTime time) {
        return formatSeconds(time.getSecond()) + "\n" + formatFiveHour(time.getHour());
    }

    public static String formatSeconds(int seconds) {
        return isEvenNumber(seconds) ? "Y" : "O";
    }

    private static boolean isEvenNumber(int seconds) {
        return seconds % 2 == 0;
    }

    public static String formatFiveHour(int hours) {
        assert hours >= 0 && hours < 23 : "There is only 23 hours in a day";
        int nbLightOn = hours / 5;

        return IntStream.range(0, 4)
                .mapToObj(value -> {
                    if (value < nbLightOn) {
                        return "R";
                    }
                    return "O";
                })
                .collect(Collectors.joining());
    }
}

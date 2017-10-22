package berlinsclock;

import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock {
    public static String format(LocalTime time) {
        final Hours hours = Hours.of(time.getHour());
        final Seconds seconds = Seconds.of(time.getSecond());

        return formatSeconds(seconds)
                + "\n" + formatFiveHour(hours)
                + "\n" + formatOneHour(hours);
    }

    public static String formatSeconds(Seconds seconds) {
        return isEvenNumber(seconds.getNumber()) ? "Y" : "O";
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public static String formatFiveHour(Hours hours) {
        int nbLightOn = hours.getNumber() / 5;

        return formatOnLights(nbLightOn);
    }

    public static String formatOneHour(Hours hours) {
        final int nbLightOn = hours.getNumber() % 5;

        return formatOnLights(nbLightOn);
    }

    private static String formatOnLights(int nbLightOn) {
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

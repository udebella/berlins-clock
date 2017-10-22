package berlinsclock;

import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock {
    private static final String LINE_SEPARATOR = "\n";
    private static final String YELLOW_LIGHT_ON = "Y";
    private static final String LIGHT_OFF = "O";
    private static final String RED_LIGHT_ON = "R";

    public static String format(LocalTime time) {
        final Hours hours = Hours.of(time.getHour());
        final Seconds seconds = Seconds.of(time.getSecond());

        return formatSeconds(seconds)
                + LINE_SEPARATOR + formatFiveHour(hours)
                + LINE_SEPARATOR + formatOneHour(hours);
    }

    public static String formatSeconds(Seconds seconds) {
        return isEvenNumber(seconds.getNumber()) ? RED_LIGHT_ON : LIGHT_OFF;
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

    public static String formatOneMinute(Minute minute) {
        return formatOnLights(minute.getNumber(), YELLOW_LIGHT_ON);
    }

    private static String formatOnLights(int nbLightOn) {
        return formatOnLights(nbLightOn, RED_LIGHT_ON);
    }

    private static String formatOnLights(int nbLightOn, String light) {
        return IntStream.range(0, 4)
                .mapToObj(value -> {
                    if (value < nbLightOn) {
                        return light;
                    }
                    return LIGHT_OFF;
                })
                .collect(Collectors.joining());
    }
}

package berlinsclock;

import java.time.LocalTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock {
    private static final String LINE_SEPARATOR = "\n";

    public static String format(LocalTime time) {
        final Hours hours = Hours.of(time.getHour());
        final Seconds seconds = Seconds.of(time.getSecond());
        final Minute minute = Minute.of(time.getMinute());

        return formatSeconds(seconds)
                + LINE_SEPARATOR + formatFiveHour(hours)
                + LINE_SEPARATOR + formatOneHour(hours)
                + LINE_SEPARATOR + formatOneMinute(minute);
    }

    public static String formatSeconds(Seconds seconds) {
        return isEvenNumber(seconds.getNumber()) ? LightTypes.RED_LIGHT_ON.stringRepresentation : LightTypes.LIGHT_OFF.stringRepresentation;
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
        final int nbLightOn = minute.getNumber() % 5;

        return formatOnLights(nbLightOn, LightTypes.YELLOW_LIGHT_ON);
    }

    public static String formatFiveMinute(Minute minute) {
        int nbLightOn = minute.getNumber() / 5;
        return IntStream.range(0, 11)
                .mapToObj(value -> {
                    if (value < nbLightOn) {
                        return LightTypes.YELLOW_LIGHT_ON;
                    }
                    return LightTypes.LIGHT_OFF;
                })
                .map(lightType -> lightType.stringRepresentation)
                .collect(Collectors.joining());
    }

    private static String formatOnLights(int nbLightOn) {
        return formatOnLights(nbLightOn, LightTypes.RED_LIGHT_ON);
    }

    private static String formatOnLights(int nbLightOn, LightTypes light) {
        return IntStream.range(0, 4)
                .mapToObj(value -> {
                    if (value < nbLightOn) {
                        return light;
                    }
                    return LightTypes.LIGHT_OFF;
                })
                .map(lightType -> lightType.stringRepresentation)
                .collect(Collectors.joining());
    }

    private enum LightTypes {
        YELLOW_LIGHT_ON("Y"),
        RED_LIGHT_ON("R"),
        LIGHT_OFF("O");

        private final String stringRepresentation;

        LightTypes(String stringRepresentation) {
            this.stringRepresentation = stringRepresentation;
        }
    }
}

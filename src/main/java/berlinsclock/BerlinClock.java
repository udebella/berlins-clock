package berlinsclock;

import java.time.LocalTime;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock {
    private static final String LINE_SEPARATOR = "\n";

    public String format(LocalTime time) {
        final Hours hours = Hours.of(time.getHour());
        final Seconds seconds = Seconds.of(time.getSecond());
        final Minute minute = Minute.of(time.getMinute());

        return formatSeconds(seconds)
                + LINE_SEPARATOR + formatFiveHour(hours)
                + LINE_SEPARATOR + formatOneHour(hours)
                + LINE_SEPARATOR + formatFiveMinute(minute)
                + LINE_SEPARATOR + formatOneMinute(minute);
    }

    public String formatSeconds(Seconds seconds) {
        return isEvenNumber(seconds.getNumber()) ? LightTypes.RED_LIGHT_ON.stringRepresentation : LightTypes.LIGHT_OFF.stringRepresentation;
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public String formatFiveHour(Hours hours) {
        int nbLightOn = hours.getNumber() / 5;

        return formatOnLights(nbLightOn);
    }

    public String formatOneHour(Hours hours) {
        final int nbLightOn = hours.getNumber() % 5;

        return formatOnLights(nbLightOn);
    }

    public String formatOneMinute(Minute minute) {
        final int nbLightOn = minute.getNumber() % 5;

        return formatOnLights(4, onOffLightMapper(nbLightOn, value -> LightTypes.YELLOW_LIGHT_ON));
    }

    public String formatFiveMinute(Minute minute) {
        int nbLightOn = minute.getNumber() / 5;
        return formatOnLights(11, onOffLightMapper(nbLightOn, this::redYellowLightAlternate));
    }

    private String formatOnLights(int nbLightOn) {
        return formatOnLights(4, onOffLightMapper(nbLightOn, value -> LightTypes.RED_LIGHT_ON));
    }

    private String formatOnLights(int nbLightTotal, IntFunction<LightTypes> lightToDisplayMapper) {
        return IntStream.range(0, nbLightTotal)
                .mapToObj(lightToDisplayMapper)
                .map(lightType -> lightType.stringRepresentation)
                .collect(Collectors.joining());
    }

    private IntFunction<LightTypes> onOffLightMapper(int nbLightOn, IntFunction<LightTypes> onLightMapper) {
        return value -> {
            if (value < nbLightOn) {
                return onLightMapper.apply(value);
            }
            return LightTypes.LIGHT_OFF;
        };
    }

    private LightTypes redYellowLightAlternate(int value) {
        if ((value + 1) % 3 == 0) {
            return LightTypes.RED_LIGHT_ON;
        }
        return LightTypes.YELLOW_LIGHT_ON;
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

package berlinsclock;

import org.junit.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockFeature {
    @Test
    public void should_convert_a_digital_time_into_berlin_representation() {
        LocalTime time = LocalTime.of(19, 42, 55);

        String berlinRepresentation = BerlinClock.format(time);

        assertThat(berlinRepresentation).isEqualTo("O\nRRRO\nRRRR\nYYRYYRYYOOO\nYYOO");
    }

    @Test
    public void should_convert_midnight() {
        LocalTime time = LocalTime.of(0, 0, 0);

        String berlinRepresentation = BerlinClock.format(time);

        assertThat(berlinRepresentation).isEqualTo("R\nOOOO\nOOOO\nOOOOOOOOOOO\nOOOO");
    }

    @Test
    public void should_convert_one_second_to_midnight() {
        LocalTime time = LocalTime.of(23, 59, 59);

        String berlinRepresentation = BerlinClock.format(time);

        assertThat(berlinRepresentation).isEqualTo("O\nRRRR\nRRRO\nYYRYYRYYRYY\nYYYY");
    }

    @Test
    public void should_convert_10_to_4_pm() {
        LocalTime time = LocalTime.of(16, 50, 6);

        String berlinRepresentation = BerlinClock.format(time);

        assertThat(berlinRepresentation).isEqualTo("R\nRRRO\nROOO\nYYRYYRYYRYO\nOOOO");
    }

    @Test
    public void should_convert_23_to_11_am() {
        LocalTime time = LocalTime.of(11, 37, 1);

        String berlinRepresentation = BerlinClock.format(time);

        assertThat(berlinRepresentation).isEqualTo("O\nRROO\nROOO\nYYRYYRYOOOO\nYYOO");
    }
}
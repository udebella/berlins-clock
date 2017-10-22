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
}

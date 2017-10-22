package berlinsclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {
    @Test
    public void should_be_on_when_seconds_are_even() {
        assertThat(BerlinClock.formatSeconds(4)).isEqualTo("Y");
    }

    @Test
    public void should_be_off_when_seconds_are_odd() {
        assertThat(BerlinClock.formatSeconds(3)).isEqualTo("O");
    }
}

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

    @Test
    public void all_lights_should_be_stopped_when_hour_is_0() {
        assertThat(BerlinClock.formatFiveHour(0)).isEqualTo("OOOO");
    }

    @Test
    public void first_light_should_be_on_when_hour_is_5() {
        assertThat(BerlinClock.formatFiveHour(5)).isEqualTo("ROOO");
    }

    @Test
    public void first_light_should_be_on_when_hour_is_6() {
        assertThat(BerlinClock.formatFiveHour(6)).isEqualTo("ROOO");
    }

    @Test
    public void the_two_first_light_should_be_on_when_hour_is_10() {
        assertThat(BerlinClock.formatFiveHour(10)).isEqualTo("RROO");
    }

    @Test(expected = AssertionError.class)
    public void should_not_allow_more_than_24_hour() {
        BerlinClock.formatFiveHour(24);
    }

    @Test(expected = AssertionError.class)
    public void should_not_allow_negative_hours() {
        BerlinClock.formatFiveHour(-1);
    }
}

package berlinsclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BerlinClockTest {
    @Test
    public void seconds_light_should_be_on_when_seconds_are_even() {
        final Seconds seconds = Seconds.of(4);
        assertThat(BerlinClock.formatSeconds(seconds)).isEqualTo("Y");
    }

    @Test
    public void seconds_light_should_be_off_when_seconds_are_odd() {
        final Seconds seconds = Seconds.of(3);
        assertThat(BerlinClock.formatSeconds(seconds)).isEqualTo("O");
    }

    @Test
    public void all_five_hour_lights_should_be_stopped_when_hour_is_0() {
        final Hours hours = Hours.of(0);
        assertThat(BerlinClock.formatFiveHour(hours)).isEqualTo("OOOO");
    }

    @Test
    public void first_five_hour_light_should_be_on_when_hour_is_5() {
        final Hours hours = Hours.of(5);
        assertThat(BerlinClock.formatFiveHour(hours)).isEqualTo("ROOO");
    }

    @Test
    public void first_five_hour_light_should_be_on_when_hour_is_6() {
        final Hours hours = Hours.of(6);
        assertThat(BerlinClock.formatFiveHour(hours)).isEqualTo("ROOO");
    }

    @Test
    public void the_two_first_five_hour_lights_should_be_on_when_hour_is_10() {
        final Hours hours = Hours.of(10);
        assertThat(BerlinClock.formatFiveHour(hours)).isEqualTo("RROO");
    }

    @Test
    public void all_one_hour_lights_should_be_stopped_when_hour_is_0() {
        final Hours hours = Hours.of(0);
        assertThat(BerlinClock.formatOneHour(hours)).isEqualTo("OOOO");
    }

    @Test
    public void first_one_hour_light_should_be_on_when_hour_is_1() {
        final Hours hours = Hours.of(1);
        assertThat(BerlinClock.formatOneHour(hours)).isEqualTo("ROOO");
    }

    @Test
    public void all_one_hour_lights_should_be_stopped_when_hour_is_5() {
        final Hours hours = Hours.of(5);
        assertThat(BerlinClock.formatOneHour(hours)).isEqualTo("OOOO");
    }
}

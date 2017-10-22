package berlinsclock;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MinuteTest {

    @Test(expected = AssertionError.class)
    public void should_not_allow_more_than_60_seconds() {
        Minute.of(60);
    }

    @Test(expected = AssertionError.class)
    public void should_not_allow_negative_seconds() {
        Minute.of(-1);
    }

    @Test
    public void should_build_proper_minute() {
        final Minute minute = Minute.of(4);
        assertThat(minute).isNotNull();
        assertThat(minute.getNumber()).isEqualTo(4);
    }
}
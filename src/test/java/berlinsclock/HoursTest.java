package berlinsclock;

import org.junit.Test;

public class HoursTest {
    @Test(expected = AssertionError.class)
    public void should_not_allow_more_than_24_hour() {
        Hours.of(24);
    }

    @Test(expected = AssertionError.class)
    public void should_not_allow_negative_hours() {
        Hours.of(-1);
    }
}
package berlinsclock;

import org.junit.Test;

public class SecondsTest {

    @Test(expected = AssertionError.class)
    public void should_not_allow_more_than_60_seconds() {
        Seconds.of(60);
    }

    @Test(expected = AssertionError.class)
    public void should_not_allow_negative_seconds() {
        Seconds.of(-1);
    }

}
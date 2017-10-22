package berlinsclock;

import org.junit.Test;

public class MinuteTest {

    @Test(expected = AssertionError.class)
    public void should_not_allow_more_than_60_seconds() {
        Minute.of(60);
    }

    @Test(expected = AssertionError.class)
    public void should_not_allow_negative_seconds() {
        Minute.of(-1);
    }
}
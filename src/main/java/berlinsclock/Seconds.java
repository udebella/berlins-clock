package berlinsclock;

public class Seconds {
    private int number;

    private Seconds(int number) {
        this.number = number;
    }

    public static Seconds of(int number) {
        assert number >= 0 && number < 60 : "Seconds should be between 0 and 60";
        return new Seconds(number);
    }

    public int getNumber() {
        return number;
    }
}

package berlinsclock;

public class Minute {
    private int number;

    public Minute(int number) {
        this.number = number;
    }

    public static Minute of(int number) {
        assert number >= 0 && number < 60 : "Minutes should be between 0 and 60";
        return new Minute(number);
    }

    public int getNumber() {
        return number;
    }
}

package berlinsclock;

public class Hours {
    private int number;

    private Hours(int number) {
        this.number = number;
    }

    public static Hours of(int number) {
        assert number >= 0 && number < 23 : "Hours should be between 0 and 23";
        return new Hours(number);
    }

    public int getNumber() {
        return number;
    }
}

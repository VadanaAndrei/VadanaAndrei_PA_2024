public class Tile {
    private final Integer firstNumber;
    private final Integer secondNumber;

    public Tile(Integer firstNumber, Integer secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public Integer getFirstNumber() {
        return firstNumber;
    }

    public Integer getSecondNumber() {
        return secondNumber;
    }

    @Override
    public String toString() {
        return "(" + firstNumber + ", " + secondNumber + ")";
    }
}

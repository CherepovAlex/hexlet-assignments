package exercise;

// BEGIN
public class NegativeRadiusException extends Exception{
    public NegativeRadiusException(String line) {
        super("Не удалось посчитать площадь");
    }
}
// END

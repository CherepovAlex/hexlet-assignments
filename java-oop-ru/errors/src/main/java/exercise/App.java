package exercise;

// BEGIN
public class App {

    public static void printSquare(Circle circle) throws NegativeRadiusException {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println("Не удалось посчитать площадь");
        }
        System.out.println("Вычисление окончено");
    }

    public static void main(String[] args) throws NegativeRadiusException {
        Point point1 = new Point(3, 4);
        Circle circle1 = new Circle(point1, 1);
        circle1.getRadius(); // 1
        circle1.getSquare(); // 3.1415...

        try {
            Circle circle2 = new Circle(point1, -1);
            System.out.println(circle2.getSquare());
        } catch (NegativeRadiusException e) {
            System.out.println(e.getMessage());
        }


        Point point2 = new Point(5, 7);
        Circle circle2 = new Circle(point2, 4);
        App.printSquare(circle2);
        // => "50"
        // => "Вычисление окончено"

        Circle circle3 = new Circle(point2, -2);
        App.printSquare(circle3);
        // => "Не удалось посчитать площадь"
        // => "Вычисление окончено"
    }
}
// END

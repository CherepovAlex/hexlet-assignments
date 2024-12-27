package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static Lsit<String> buildApartmentsList(List<Home> apartments, int number) {
        //TODO Метод сортирует объекты по площади по возрастанию

    }

    public static void main(String[] args) {
        Home flat = new Flat(54.5, 4, 3);
        double area = flat.getArea(); // 58.5
        flat.toString(); // "Квартира площадью 58.5 метров на 3 этаже"

        Home cottage = new Cottage(135, 2);
        double area = cottage.getArea(); // 135
        cottage.toString(); // "2 этажный коттедж площадью 135 метров"

        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));

        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result); // =>
// [
//     Квартира площадью 44.0 метров на 10 этаже,
//     Квартира площадью 90.0 метров на 2 этаже,
//     2 этажный коттедж площадью 125.5 метров
// ]

        CharSequence text = new ReversedSequence("abcdef");
        text.toString(); // "fedcba"
        text.charAt(1); // 'e'
        text.length(); // 6
        text.subSequence(1, 4).toString(); // "edc"

    }
}
// END

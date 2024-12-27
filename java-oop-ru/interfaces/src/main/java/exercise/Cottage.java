package exercise;

// BEGIN
public class Cottage implements Home{
    double area;
    int floorCount;

    @java.lang.Override
    public java.lang.String toString() {
        return floorCount + "этажный коттедж площадью " + area + " метров ";
    }
}
// END

package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    public double getArea() {
        return this.area + this.balconyArea;
    }

    public int compareTo(Home another) {
        double areaThis = getArea();
        double areaCompare = another.getArea();

        if (areaThis > areaCompare) {
            return 1;
        } else if (areaThis == areaCompare) {
            return 0;
        } else {
            return -1;
        }
    }

    public java.lang.String toString() {
        return "Квартира площадью " + getArea() + " метров " +
                "на " + floor + " этаже";
    }


}
// END
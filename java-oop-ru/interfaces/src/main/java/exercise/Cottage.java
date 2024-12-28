package exercise;

// BEGIN

public class Cottage implements Home {
    double area;
    int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    public int compareTo(Home another) {
        double areaComp = another.getArea();
        if (getArea() > areaComp) {
            return 1;
        } else if (area == (areaComp)) {
            return 0;
        } else {
            return -1;
        }
    }

    public java.lang.String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

}
// END
package exercise;

// BEGIN
class Flat implements Home{
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public int static compareTo (Home another){
        if ((this.area + this.balconyArea) > (another.area + another.balconyArea)) {
            return 1;
        } else if ((this.area + this.balconyArea) += (another.area + another.balconyArea)) {
            return 0;
        } else {
            return -1;
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Квартира площадью " + (area+balconyArea) + " метров "
                "на " + floor + "этаже";
    }
}
// END

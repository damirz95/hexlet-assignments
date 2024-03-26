package exercise;

// BEGIN
public class Circle {
    Point points;
    int radius;

    public Circle(Point points, int radius) {
        this.radius = radius;
        this.points = points;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException{
        if (getRadius() < 0) {
            throw new NegativeRadiusException();
        }
        return Math.PI * (getRadius() * getRadius());
    }
}
// END

package basic.lab3.task5;

public class Circle implements Comparable<Circle>{
    private final double radius;

    public Circle(double radius) throws Exception {
        if (radius <= 0) {
            throw new Exception("The radius must be greater than 0.");
        }

        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public int compareTo(Circle circle) {
        return Double.compare(this.getRadius(), circle.getRadius());
    }
}

class Triangle extends Shape {

    private final double side1;
    private final double side2;
    private final double side3;

    Triangle(double side1, double double2, double side3) {
        this.side1 = side1;
        this.side2 = double2;
        this.side3 = side3;
    }

    @Override
    double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    double perimeter() {
        return side1 + side2 + side3;
    }
}
package basic.lab3.task3;

class PowWithInterface implements FindValueInterface {
    @Override
    public double findValue(double x) {
        return Math.pow(x, 2);
    }
}

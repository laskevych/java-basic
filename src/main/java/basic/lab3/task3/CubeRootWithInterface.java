package basic.lab3.task3;

class CubeRootWithInterface implements FindValueInterface {
    @Override
    public double findValue(double x) {
        return Math.cbrt(x);
    }
}

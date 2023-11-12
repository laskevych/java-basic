package basic.lab3.task3;

class CubeRootWithAbstractClass extends FindValueAbstractClass {
    @Override
    double findValue(double x) {
        return Math.cbrt(x);
    }
}

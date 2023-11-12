package basic.lab3.task3;

class PowWithAbstractClass extends FindValueAbstractClass {
    @Override
    double findValue(double x) {
        return Math.pow(x, 2);
    }
}

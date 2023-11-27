package basic.lab3.task3;

class CubeRootWithAbstractClass extends FindValueAbstractClass {
    @Override
    double function(double x) {
        return Math.cbrt(x);
    }
}

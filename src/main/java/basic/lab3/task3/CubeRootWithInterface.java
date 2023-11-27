package basic.lab3.task3;

class CubeRootWithInterface implements FindValueInterface {
    @Override
    public double function(double x) {
        return Math.cbrt(x);
    }
}

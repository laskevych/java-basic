package basic.lab3.task3;

class FindMinimum {
    static void verifyInterval(double start, double end, double step) throws Exception {
        if (start > end && step <= 0) {
            throw new Exception("Invalid interval: ensure step > 0 and start <= end.");
        } else if (start > end) {
            throw new Exception("Invalid interval: start should be less than or equal to end.");
        } else if (step <= 0) {
            throw new Exception("Invalid interval: step should be greater than 0.");
        }
    }

    static double findMinValueByAbstractClass(double start, double end, double step, FindValueAbstractClass function) throws Exception {
        verifyInterval(start, end, step);

        double minValue = function.findValue(start);

        for (double x = start + step;  x <= end; x += step) {
            double value = function.findValue(x);

            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }

    static double findMinValueByInterface(double start, double end, double step, FindValueInterface function) throws Exception {
        verifyInterval(start, end, step);

        double minValue = function.findValue(start);

        for (double x = start + step;  x <= end; x += step) {
            double value = function.findValue(x);

            if (value < minValue) {
                minValue = value;
            }
        }

        return minValue;
    }

    static double findMinValueByAnonymousClassPow(double start, double end, double step) throws Exception {
        return findMinValueByInterface(start, end, step, new FindValueInterface() {
            @Override
            public double findValue(double x) {
                return Math.pow(x, 2);
            }
        });
    }

    static double findMinValueByAnonymousClassCubeRoot(double start, double end, double step) throws Exception {
        return findMinValueByInterface(start, end, step, new FindValueInterface() {
            @Override
            public double findValue(double x) {
                return Math.cbrt(x);
            }
        });
    }

    static double findMinValueByLambdaExpressionsPow(double start, double end, double step) throws Exception {
        return findMinValueByInterface(start, end, step, x -> Math.pow(x, 2));
    }

    static double findMinValueByLambdaExpressionsCubeRoot(double start, double end, double step) throws Exception {
        return findMinValueByInterface(start, end, step, Math::cbrt);
    }

    static double powerFunction(double x) {
        return Math.pow(x, 2);
    }

    static double CubeRootFunction(double x) {
        return Math.cbrt(x);
    }

    static double findMinValueByReferencesToMethodPow(double start, double end, double step) throws Exception {
        return findMinValueByInterface(start, end, step, FindMinimum::powerFunction);
    }

    static double findMinValueByReferencesToMethodCubeRoot(double start, double end, double step) throws Exception {
        return findMinValueByInterface(start, end, step, FindMinimum::CubeRootFunction);
    }
}

package Jacobi;

public class Defmatrix {
    public static double[][] obtenerMatrizA() {
        return new double[][] {
                {5.0, 1.0, 1.0},
                {1.0, 4.0, 1.0},
                {1.0, 2.0, 5.0}
        };
    }

    public static double[] obtenerVectorB() {
        return new double[] {7.0, 6.0, 8.0};
    }

    public static double[] obtenerVectorX0() {
        return new double[] {0.0, 0.0, 0.0};
    }
}
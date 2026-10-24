package Jacobi;

public class MetodoGaussSeidel {

    public static double[] resolver(double[][] A, double[] b, double[] x0, double tol, int maxIter) {
        int n = b.length;
        double[] x = x0.clone(); // Vector que se actualiza inmediatamente

        for (int k = 0; k < maxIter; k++) {
            double[] xAnt = x.clone(); // Copia para cálculo de error

            for (int i = 0; i < n; i++) {
                double suma = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        suma += A[i][j] * x[j]; // Usa los valores ya actualizados de x
                    }
                }
                x[i] = (b[i] - suma) / A[i][i]; // Actualización inmediata
            }

            if (MetodoJacobi.calcularError(xAnt, x) < tol) {
                return x; // Convergió
            }
        }
        return x;
    }
}
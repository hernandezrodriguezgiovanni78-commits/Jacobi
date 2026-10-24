package Jacobi;

public class MetodoJacobi {

    /**
     * Resuelve un sistema de ecuaciones lineales mediante el método iterativo de Jacobi.
     *
     * @param A      Matriz de coeficientes (cuadrada)
     * @param b      Vector de términos independientes
     * @param x0     Vector de aproximación inicial
     * @param tol    Tolerancia o error máximo permitido
     * @param maxIter Número máximo de iteraciones
     * @return       Vector con la solución aproximada
     */
    public static double[] resolver(double[][] A, double[] b, double[] x0, double tol, int maxIter) {
        int n = b.length;
        double[] x = x0.clone(); // Copia de la aproximación actual
        double[] xNuevo = new double[n]; // Vector para almacenar la nueva aproximación

        // Ciclo principal de iteraciones (su función es repetir el cálculo una y otra vez
        // para ir afinando la respuesta, con un límite máximo)
        for (int k = 0; k < maxIter; k++) {

            // Cálculo de cada variable para la nueva iteración
            for (int i = 0; i < n; i++) { // cada fila
                double suma = 0.0; // tenemos que resetear la suma de cada fila

                // Sumatoria de los términos A[i][j] * x[j] excluyendo la diagonal (j != i)
                for (int j = 0; j < n; j++) { // cada columna
                    if (j != i) { // tenemos que sumar todos excepto los de la diagonal
                        suma += A[i][j] * x[j]; // xj valores x, y, z
                    }
                }

                // Fórmula de despeje de Jacobi: x_i = (b_i - suma) / A[i][i]
                xNuevo[i] = (b[i] - suma) / A[i][i];
            }

            // Evalúa si ya se alcanzó la precisión deseada (criterio de parada)
            if (calcularError(x, xNuevo) < tol) {
                return xNuevo; // Convergió con éxito
            }

            // Actualiza el vector para la siguiente iteración si es que todavía el error es muy grande
            x = xNuevo.clone();
        }

        // Retorna la última aproximación si se agotan las iteraciones sin converger del todo
        return xNuevo;
    }

    /**
     * Calcula el error máximo absoluto entre dos vectores (Norma Infinito).
     */
    public static double calcularError(double[] xAnt, double[] xNuevo) {
        double max = 0.0;
        for (int i = 0; i < xAnt.length; i++) {
            // Encuentra la máxima diferencia absoluta entre elementos correspondientes
            max = Math.max(max, Math.abs(xNuevo[i] - xAnt[i]));
        }
        return max;
    }
}
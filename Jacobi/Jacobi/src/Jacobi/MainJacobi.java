package Jacobi;

public class MainJacobi {

    public static void main(String[] args) {
        // Carga de datos
        double[][] A = Defmatrix.obtenerMatrizA();
        double[] b = Defmatrix.obtenerVectorB();
        double[] x0 = Defmatrix.obtenerVectorX0();

        // Tolerancia según requerimiento (0.0001)
        double tol = 0.0001;
        int maxIter = 100;

        // Ejecución Jacobi
        double[] solJacobi = MetodoJacobi.resolver(A, b, x0, tol, maxIter);
        System.out.print("Solución Jacobi: [ ");
        for (double val : solJacobi) {
            System.out.printf("%.5f ", val);
        }
        System.out.println("]");

        // Ejecución Gauss-Seidel
        double[] solGaussSeidel = MetodoGaussSeidel.resolver(A, b, x0, tol, maxIter);
        System.out.print("Solución Gauss-Seidel: [ ");
        for (double val : solGaussSeidel) {
            System.out.printf("%.5f ", val);
        }
        System.out.println("]");
    }
}
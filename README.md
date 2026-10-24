# Sistema de Ecuaciones Lineales - Métodos Iterativos (Jacobi y Gauss-Seidel)

Este repositorio contiene la implementación en Java para la resolución de sistemas de ecuaciones lineales mediante métodos numéricos iterativos, aplicando una arquitectura modular basada en separación de responsabilidades.

---

## Descripción del Proyecto

El programa resuelve el siguiente sistema de ecuaciones de 3x3:

5x + y + z = 7
x + 4y + z = 6
x + 2y + 5z = 8

Con un vector de aproximación inicial X(0) = [0, 0, 0] y un criterio de parada con tolerancia de error de 0.0001 (1e-4).

---

## Arquitectura del Proyecto

El proyecto está organizado dentro del paquete Jacobi respetando los tres componentes requeridos:

src/
└── Jacobi/
    ├── Defmatrix.java          # Módulo 1: Definición de la matriz A, vector b y X0
    ├── MetodoJacobi.java       # Módulo 2: Lógica del Método de Jacobi
    ├── MetodoGaussSeidel.java  # Módulo 2: Lógica del Método de Gauss-Seidel
    └── MainJacobi.java         # Módulo 3: Clase Principal (Ejecución y Comparativa)

---

## Requisitos e Instalación

* Java Development Kit (JDK): Versión 11 o superior.
* IDE recomendado: IntelliJ IDEA, Eclipse o VS Code.

### Compilación y Ejecución desde Terminal

1. Clonar el repositorio:
   git clone https://github.com/TU_USUARIO/TU_REPOSITO.git
   cd TU_REPOSITORIO/src

2. Compilar el código:
   javac Jacobi/*.java

3. Ejecutar la clase principal:
   java Jacobi.MainJacobi

---

## Comparativa de Resultados (Tolerancia = 0.0001)

| Método | Iteraciones | Solución Aproximada [x, y, z] |
| :--- | :---: | :---: |
| Jacobi | 10 | [ 0.99999, 0.99998, 0.99998 ] |
| Gauss-Seidel | 6 | [ 0.99999, 1.00000, 1.00000 ] |

### Conclusión Técnica
El Método de Gauss-Seidel convergió más rápido (6 iteraciones frente a 10 de Jacobi) debido a que utiliza las actualizaciones inmediatas de las variables dentro de la misma iteración, logrando mayor precisión con un menor número de ciclos.

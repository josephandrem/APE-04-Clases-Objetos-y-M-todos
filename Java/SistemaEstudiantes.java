/*
 * ============================================================
 *  SISTEMA DE CONTROL DE ESTUDIANTES Y CALIFICACIONES
 *  Asignatura: Algoritmos y Lógica de Programación
 *  Guía: SW-AyLP-APE-04 - Clases, Objetos y Métodos
 *  Lenguaje: Java
 * ============================================================
 *
 *  Descripción:
 *    Programa que registra información de estudiantes, calcula
 *    promedios y determina si aprueban o reprueban (promedio >= 7).
 *
 *  Estructura de archivos:
 *    Este archivo contiene DOS clases en el mismo .java para
 *    facilitar la entrega. En un proyecto real, cada clase
 *    iría en su propio archivo (.java).
 *
 *  Buenas prácticas aplicadas:
 *    - Encapsulamiento: atributos privados con getters/setters
 *    - Responsabilidad única: cada método hace una sola tarea
 *    - Validación de datos en los setters
 *    - Javadoc en métodos públicos
 *    - Nombres de variables y métodos en camelCase (convención Java)
 * ============================================================
 */

import java.util.ArrayList;   // Lista dinámica de estudiantes
import java.util.Scanner;      // Lectura de datos desde consola

// ============================================================
//  CLASE: Estudiante
//  Representa a un estudiante con sus datos académicos.
//  Debe estar en su propio archivo Estudiante.java en proyectos
//  reales; aquí se incluye junto al main por comodidad.
// ============================================================
class Estudiante {

    // ── Atributos privados ──────────────────────────────────
    // Solo son accesibles desde dentro de la clase.
    // Se usan getters/setters para interactuar con ellos.
    private String cedula;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;
    private double nota3;
    private double promedio;
    private String estado;      // "Aprobado" o "Reprobado"

    // ── Constructor ─────────────────────────────────────────
    /**
     * Construye un objeto Estudiante inicializando todos sus datos.
     * Calcula automáticamente el promedio y el estado al crearse.
     *
     * @param cedula   Número de cédula del estudiante
     * @param nombre   Primer nombre
     * @param apellido Apellido del estudiante
     * @param nota1    Primera nota (debe estar entre 0 y 10)
     * @param nota2    Segunda nota (debe estar entre 0 y 10)
     * @param nota3    Tercera nota  (debe estar entre 0 y 10)
     */
    public Estudiante(String cedula, String nombre, String apellido,
                      double nota1, double nota2, double nota3) {
        this.cedula   = cedula;
        this.nombre   = nombre;
        this.apellido = apellido;

        // Usamos los setters para aprovechar la validación
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);

        // Calculamos promedio y estado al construir el objeto
        calcularPromedio();
        determinarEstado();
    }

    // ── Getters ─────────────────────────────────────────────
    // Permiten leer los atributos privados desde fuera de la clase.

    /** @return Cédula del estudiante */
    public String getCedula()   { return cedula;   }

    /** @return Nombre del estudiante */
    public String getNombre()   { return nombre;   }

    /** @return Apellido del estudiante */
    public String getApellido() { return apellido; }

    /** @return Primera nota */
    public double getNota1()    { return nota1;    }

    /** @return Segunda nota */
    public double getNota2()    { return nota2;    }

    /** @return Tercera nota */
    public double getNota3()    { return nota3;    }

    /** @return Promedio calculado de las tres notas */
    public double getPromedio() { return promedio; }

    /** @return Estado: "Aprobado" o "Reprobado" */
    public String getEstado()   { return estado;   }

    // ── Setters con validación ───────────────────────────────
    // Permiten modificar los atributos con control de valores.
    // Las notas deben estar entre 0 y 10; si no, se asigna 0.

    /** @param cedula Nueva cédula */
    public void setCedula(String cedula)     { this.cedula   = cedula;   }

    /** @param nombre Nuevo nombre */
    public void setNombre(String nombre)     { this.nombre   = nombre;   }

    /** @param apellido Nuevo apellido */
    public void setApellido(String apellido) { this.apellido = apellido; }

    /**
     * Asigna la nota 1 validando que esté en el rango [0, 10].
     * @param nota Valor de la nota; si es inválido se asigna 0.
     */
    public void setNota1(double nota) {
        this.nota1 = (nota >= 0 && nota <= 10) ? nota : 0;
    }

    /**
     * Asigna la nota 2 validando que esté en el rango [0, 10].
     * @param nota Valor de la nota; si es inválido se asigna 0.
     */
    public void setNota2(double nota) {
        this.nota2 = (nota >= 0 && nota <= 10) ? nota : 0;
    }

    /**
     * Asigna la nota 3 validando que esté en el rango [0, 10].
     * @param nota Valor de la nota; si es inválido se asigna 0.
     */
    public void setNota3(double nota) {
        this.nota3 = (nota >= 0 && nota <= 10) ? nota : 0;
    }

    // ── Método: calcularPromedio ─────────────────────────────
    /**
     * Calcula el promedio aritmético de las tres notas
     * y actualiza el atributo 'promedio' del objeto.
     */
    public void calcularPromedio() {
        this.promedio = (nota1 + nota2 + nota3) / 3.0;
    }

    // ── Método: determinarEstado ─────────────────────────────
    /**
     * Evalúa si el estudiante aprueba o reprueba.
     * Condición de aprobación: promedio >= 7.00
     * Actualiza el atributo 'estado' del objeto.
     */
    public void determinarEstado() {
        this.estado = (promedio >= 7.00) ? "Aprobado" : "Reprobado";
    }

    // ── Método: mostrarInformacion ───────────────────────────
    /**
     * Imprime en consola todos los datos del estudiante
     * con formato alineado y dos decimales en las notas.
     */
    public void mostrarInformacion() {
        System.out.println("---------------------------------------------");
        System.out.printf("  Cédula   : %s%n",     cedula);
        System.out.printf("  Nombre   : %s %s%n",  nombre, apellido);
        System.out.printf("  Nota 1   : %.2f%n",   nota1);
        System.out.printf("  Nota 2   : %.2f%n",   nota2);
        System.out.printf("  Nota 3   : %.2f%n",   nota3);
        System.out.printf("  Promedio : %.2f%n",   promedio);
        System.out.printf("  Estado   : %s%n",     estado);
        System.out.println("---------------------------------------------");
    }

}   // Fin de la clase Estudiante


// ============================================================
//  CLASE PRINCIPAL: SistemaEstudiantes
//  Contiene el método main que orquesta todo el programa.
//  Nota: el nombre del archivo debe coincidir con esta clase
//        → SistemaEstudiantes.java
// ============================================================
public class SistemaEstudiantes {

    // ── Método auxiliar: leerNota ────────────────────────────
    /**
     * Lee y valida una nota ingresada por el usuario.
     * Repite la solicitud mientras la nota esté fuera de [0, 10].
     *
     * @param sc       Scanner activo para leer desde consola
     * @param etiqueta Texto que identifica la nota (ej: "Nota 1")
     * @return         Nota válida ingresada por el usuario
     */
    private static double leerNota(Scanner sc, String etiqueta) {
        double nota;
        do {
            System.out.print("    " + etiqueta + " (0 - 10): ");
            nota = sc.nextDouble();
            if (nota < 0 || nota > 10) {
                System.out.println("    ⚠  Nota inválida. Debe estar entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        return nota;
    }

    // ── Método principal: main ───────────────────────────────
    /**
     * Punto de entrada del programa.
     * Gestiona el ingreso de datos y la presentación de resultados.
     *
     * @param args Argumentos de línea de comandos (no se usan)
     */
    public static void main(String[] args) {

        // Constante: número mínimo de estudiantes a registrar
        final int TOTAL_ESTUDIANTES = 5;

        // Lista dinámica que almacena los objetos Estudiante
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        // Scanner para leer datos del usuario desde la consola
        Scanner sc = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("  SISTEMA DE CONTROL DE ESTUDIANTES - Java  ");
        System.out.println("=============================================");

        // ── Ingreso de datos ────────────────────────────────
        for (int i = 1; i <= TOTAL_ESTUDIANTES; i++) {

            System.out.println("\n>> Ingreso de datos - Estudiante " + i);

            System.out.print("  Cédula   : ");
            String cedula = sc.next();

            System.out.print("  Nombre   : ");
            String nombre = sc.next();

            System.out.print("  Apellido : ");
            String apellido = sc.next();

            // Leer las tres notas con validación
            double n1 = leerNota(sc, "Nota 1");
            double n2 = leerNota(sc, "Nota 2");
            double n3 = leerNota(sc, "Nota 3");

            // Crear el objeto Estudiante y agregarlo a la lista
            Estudiante est = new Estudiante(cedula, nombre, apellido, n1, n2, n3);
            listaEstudiantes.add(est);
        }

        // ── Listado completo de estudiantes ─────────────────
        System.out.println("\n\n=============================================");
        System.out.println("       LISTADO COMPLETO DE ESTUDIANTES       ");
        System.out.println("=============================================");

        int aprobados  = 0;
        int reprobados = 0;

        for (Estudiante est : listaEstudiantes) {
            est.mostrarInformacion();

            // Contar aprobados y reprobados
            if (est.getEstado().equals("Aprobado")) {
                aprobados++;
            } else {
                reprobados++;
            }
        }

        // ── Resumen estadístico ─────────────────────────────
        System.out.println("\n=============================================");
        System.out.println("               RESUMEN FINAL                 ");
        System.out.println("=============================================");
        System.out.println("  Total de estudiantes : " + TOTAL_ESTUDIANTES);
        System.out.println("  Aprobados            : " + aprobados);
        System.out.println("  Reprobados           : " + reprobados);
        System.out.println("=============================================");

        sc.close();     // Buena práctica: cerrar el Scanner al terminar
    }

}   // Fin de la clase SistemaEstudiantes

#include <iostream>   // Para cin y cout
#include <iomanip>    // Para setprecision (formateo de decimales)
#include <string>     // Para el tipo string
#include <vector>     // Para almacenar múltiples estudiantes

using namespace std;

// ============================================================
//  CLASE: Estudiante
//  Representa a un estudiante con sus datos académicos.
// ============================================================
class Estudiante {

private:
    // ── Atributos privados ──────────────────────────────────
    // Solo son accesibles desde dentro de la clase.
    // Se usan getters/setters para interactuar con ellos.
    string cedula;
    string nombre;
    string apellido;
    double nota1;
    double nota2;
    double nota3;
    double promedio;
    string estado;      // "Aprobado" o "Reprobado"

public:
    // ── Constructor ─────────────────────────────────────────
    // Inicializa el objeto con todos los datos del estudiante.
    // Parámetros: cédula, nombre, apellido y las tres notas.
    Estudiante(string ced, string nom, string ape,
               double n1, double n2, double n3) {
        cedula   = ced;
        nombre   = nom;
        apellido = ape;

        // Usamos los setters para aprovechar la validación
        setNota1(n1);
        setNota2(n2);
        setNota3(n3);

        // Calculamos promedio y estado al construir el objeto
        calcularPromedio();
        determinarEstado();
    }

    // ── Getters ─────────────────────────────────────────────
    // Permiten leer los atributos privados desde fuera de la clase.

    string getCedula()   const { return cedula;   }
    string getNombre()   const { return nombre;   }
    string getApellido() const { return apellido; }
    double getNota1()    const { return nota1;    }
    double getNota2()    const { return nota2;    }
    double getNota3()    const { return nota3;    }
    double getPromedio() const { return promedio; }
    string getEstado()   const { return estado;   }

    // ── Setters con validación ───────────────────────────────
    // Permiten modificar los atributos con control de valores.
    // Las notas deben estar entre 0 y 10; si no, se asigna 0.

    void setCedula(string ced)     { cedula   = ced; }
    void setNombre(string nom)     { nombre   = nom; }
    void setApellido(string ape)   { apellido = ape; }

    void setNota1(double n) {
        // Validación: nota fuera de rango se reemplaza por 0
        nota1 = (n >= 0 && n <= 10) ? n : 0;
    }

    void setNota2(double n) {
        nota2 = (n >= 0 && n <= 10) ? n : 0;
    }

    void setNota3(double n) {
        nota3 = (n >= 0 && n <= 10) ? n : 0;
    }

    // ── Método: calcularPromedio ─────────────────────────────
    // Calcula el promedio aritmético de las tres notas.
    // Actualiza el atributo 'promedio' del objeto.
    void calcularPromedio() {
        promedio = (nota1 + nota2 + nota3) / 3.0;
    }

    // ── Método: determinarEstado ─────────────────────────────
    // Evalúa si el estudiante aprueba o reprueba.
    // Condición de aprobación: promedio >= 7.00
    void determinarEstado() {
        estado = (promedio >= 7.00) ? "Aprobado" : "Reprobado";
    }

    // ── Método: mostrarInformacion ───────────────────────────
    // Imprime en consola todos los datos del estudiante
    // con formato alineado y dos decimales en las notas.
    void mostrarInformacion() const {
        cout << fixed << setprecision(2);
        cout << "---------------------------------------------" << endl;
        cout << "  Cédula   : " << cedula              << endl;
        cout << "  Nombre   : " << nombre << " " << apellido << endl;
        cout << "  Nota 1   : " << nota1               << endl;
        cout << "  Nota 2   : " << nota2               << endl;
        cout << "  Nota 3   : " << nota3               << endl;
        cout << "  Promedio : " << promedio            << endl;
        cout << "  Estado   : " << estado              << endl;
        cout << "---------------------------------------------" << endl;
    }
};  // Fin de la clase Estudiante


// ============================================================
//  FUNCIÓN: leerNota
//  Lee y valida una nota ingresada por el usuario.
//  Repite la solicitud mientras la nota esté fuera de [0, 10].
// ============================================================
double leerNota(const string& etiqueta) {
    double nota;
    do {
        cout << "    " << etiqueta << " (0 - 10): ";
        cin  >> nota;
        if (nota < 0 || nota > 10) {
            cout << "    ⚠  Nota inválida. Debe estar entre 0 y 10." << endl;
        }
    } while (nota < 0 || nota > 10);
    return nota;
}


// ============================================================
//  FUNCIÓN PRINCIPAL: main
//  Orquesta el ingreso de datos y la presentación de resultados.
// ============================================================
int main() {

    // Constante: número mínimo de estudiantes a registrar
    const int TOTAL_ESTUDIANTES = 5;

    // Vector que almacena los objetos Estudiante creados
    vector<Estudiante> listaEstudiantes;

    cout << "=============================================" << endl;
    cout << "  SISTEMA DE CONTROL DE ESTUDIANTES - C++   " << endl;
    cout << "=============================================" << endl;

    // ── Ingreso de datos ────────────────────────────────────
    for (int i = 1; i <= TOTAL_ESTUDIANTES; i++) {

        cout << "\n>> Ingreso de datos - Estudiante " << i << endl;

        string cedula, nombre, apellido;

        cout << "  Cédula   : "; cin >> cedula;
        cout << "  Nombre   : "; cin >> nombre;
        cout << "  Apellido : "; cin >> apellido;

        // Leer las tres notas con validación
        double n1 = leerNota("Nota 1");
        double n2 = leerNota("Nota 2");
        double n3 = leerNota("Nota 3");

        // Crear el objeto Estudiante y agregarlo al vector
        Estudiante est(cedula, nombre, apellido, n1, n2, n3);
        listaEstudiantes.push_back(est);
    }

    // ── Listado completo de estudiantes ─────────────────────
    cout << "\n\n=============================================" << endl;
    cout << "       LISTADO COMPLETO DE ESTUDIANTES       " << endl;
    cout << "=============================================" << endl;

    int aprobados  = 0;
    int reprobados = 0;

    for (const Estudiante& est : listaEstudiantes) {
        est.mostrarInformacion();

        // Contar aprobados y reprobados
        if (est.getEstado() == "Aprobado") {
            aprobados++;
        } else {
            reprobados++;
        }
    }

    // ── Resumen estadístico ─────────────────────────────────
    cout << "\n=============================================" << endl;
    cout << "               RESUMEN FINAL                 " << endl;
    cout << "=============================================" << endl;
    cout << "  Total de estudiantes : " << TOTAL_ESTUDIANTES << endl;
    cout << "  Aprobados            : " << aprobados         << endl;
    cout << "  Reprobados           : " << reprobados        << endl;
    cout << "=============================================" << endl;

    return 0;   // El programa finalizó correctamente
}

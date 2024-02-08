// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Estudiante> estudiantes;

    public Main() {
        estudiantes = new ArrayList<Estudiante>();
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void imprimirPromedios() {
        if(estudiantes.size() >= 1) {
            System.out.println("Promedios de estudiantes:");
            for (int i = 0; i < estudiantes.size(); i++) {
                Estudiante estudiante = estudiantes.get(i);
                double promedio = estudiante.calcularPromedio();
                System.out.println(estudiante.getNombre() + " " + estudiante.getApellido() + ": " + promedio);
            }
        } else {
            System.out.println("No ha registrado estudiantes");
        }

    }

    public static void main(String[] args) {
        Main universidad = new Main();
        Scanner scanner = new Scanner(System.in);

        int contador = 0;

        System.out.println("Bienvenido al registro de notas");
        System.out.println("¿Cuantas notas necesita digitar en este ciclo, por cada estudiante?");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        while (true) {
            contador = 0;
            System.out.println("Ingrese el nombre del estudiante (o 'salir' para terminar):");
            String nombre = scanner.nextLine();

            if (nombre.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese el apellido del estudiante:");
            String apellido = scanner.nextLine();

            Estudiante estudiante = new Estudiante(nombre, apellido);

            while (contador < cantidad) {
                System.out.println("Ingrese una nota (o -1 para terminar), si es con decimales, puede usar una coma. ");
                System.out.println("actualmente esta en el espacio #: " + (contador + 1));
                double nota = scanner.nextDouble();
                scanner.nextLine();

                if (nota >= 1 && nota <= 5) {
                    estudiante.agregarNota(nota);
                    contador++;
                } else if (nota == -1) {
                    contador = cantidad;
                } else {
                    System.out.println("La nota debe estar entre 1 y 5");
                }
            }
            universidad.registrarEstudiante(estudiante);
        }
        scanner.close();
        universidad.imprimirPromedios();
    }
}

class Estudiante {
    private String nombre;
    private String apellido;
    private ArrayList<Double> notas;

    public Estudiante(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = new ArrayList<Double>();
    }

    public void agregarNota(double nota) {
        notas.add(nota);
    }

    public double calcularPromedio() {
        double suma = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            suma += notas.get(i);
        }
        return suma / notas.size();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}


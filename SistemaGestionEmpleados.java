import java.util.Scanner;

/**
 * Clase principal que contiene el método main para gestionar empleados.
 */
public class SistemaGestionEmpleados {

    /**
     * Método principal de la aplicación.
     * @param args Argumentos de línea de comandos (no usados).
     */
    public static void main(String[] args) {
        Empleados empleados = new Empleados(ConstantesUI.DEFAULT_CAPACIDAD);

        empleados.alta(new Empleado("Juan", Cargos.Cargo.DESARROLLADOR.getNombre(), 50000));
        empleados.alta(new Empleado("María", Cargos.Cargo.DISENADORA.getNombre(), 45000));
        empleados.alta(new Empleado("Pedro", Cargos.Cargo.GERENTE.getNombre(), 60000));

        Scanner scanner = new Scanner(System.in);
        System.out.print(ConstantesUI.INTRO_PORCENTAJE);
        double porcentaje = scanner.nextDouble();

        empleados.aumentarSalario(porcentaje);

        System.out.println(ConstantesUI.LISTA_EMPLEADOS);
        empleados.mostrarListado();

        scanner.close();
    }
}

/**
 * Clase que gestiona una colección de empleados.
 */
class Empleados {
    /**
     * Array que almacena los empleados.
     */
    private Empleado[] lista;

    /**
     * Número de empleados actualmente almacenados.
     */
    private int contador;

    /**
     * Constructor que inicializa la lista de empleados con una capacidad dada.
     * @param capacidad Número máximo de empleados.
     */
    public Empleados(int capacidad) {
        this.lista = new Empleado[capacidad];
        this.contador = 0;
    }

    /**
     * Devuelve el array de empleados.
     * @return Array de empleados.
     */
    public Empleado[] getLista() {
        return lista;
    }

    /**
     * Da de alta un nuevo empleado en la lista.
     * @param empleado Empleado a añadir.
     */
    public void alta(Empleado empleado) {
        if (contador < lista.length) {
            lista[contador++] = empleado;
        } else {
            System.out.println(ConstantesUI.NO_HAY_ESPACIO);
        }
    }

    /**
     * Aumenta el salario de todos los empleados en un porcentaje dado.
     * @param porcentaje Porcentaje de aumento.
     */
    public void aumentarSalario(double porcentaje) {
        for (Empleado empleado : lista) {
            if (empleado != null) {
                double nuevoSalario = empleado.getSalario() * (1 + porcentaje / 100);
                empleado.setSalario(nuevoSalario);
            }
        }
    }

    /**
     * Muestra por pantalla el listado de empleados.
     */
    public void mostrarListado() {
        for (Empleado empleado : lista) {
            if (empleado != null) {
                System.out.println(empleado);
            }
        }
    }
}

/**
 * Clase que representa a un empleado de la empresa.
 */
class Empleado {
    /**
     * Nombre completo del empleado.
     */
    private String nombre;

    /**
     * Puesto o cargo del empleado.
     */
    private String puesto;

    /**
     * Salario del empleado.
     */
    private double salario;

    /**
     * Constructor que inicializa un empleado con nombre, puesto y salario.
     * @param nombre Nombre completo del empleado.
     * @param puesto Puesto o cargo del empleado.
     * @param salario Salario del empleado.
     */
    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    /**
     * Devuelve el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     * @param nombre Nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el puesto del empleado.
     * @return Puesto del empleado.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del empleado.
     * @param puesto Nuevo puesto.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Devuelve el salario del empleado.
     * @return Salario del empleado.
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     * @param salario Nuevo salario.
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Devuelve una representación en texto del empleado.
     * @return Cadena con los datos del empleado.
     */
    @Override
    public String toString() {
        return nombre + " - " + puesto + " - " + salario;
    }
}
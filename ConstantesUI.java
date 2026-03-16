/**
 * Clase de utilidades para almacenar constantes de interfaz de usuario y valores fijos.
 */
public final class ConstantesUI {
    /**
     * Constructor privado para evitar instanciación.
     */
    private ConstantesUI() {}

    /**
     * Capacidad por defecto para la lista de empleados.
     */
    public static final int DEFAULT_CAPACIDAD = 3;

    /**
     * Texto para solicitar el porcentaje de aumento de salario.
     */
    public static final String INTRO_PORCENTAJE = "Introduzca el porcentaje de aumento de salario: ";

    /**
     * Texto para mostrar el listado de empleados.
     */
    public static final String LISTA_EMPLEADOS = "Lista de Empleados:";

    /**
     * Mensaje de error cuando no hay espacio para más empleados.
     */
    public static final String NO_HAY_ESPACIO = "No hay espacio para más empleados.";
}
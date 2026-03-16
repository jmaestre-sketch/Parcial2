import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

// Simulación mínima de la clase Cargos para los tests
class Cargos {
    public enum Cargo {
        DESARROLLADOR("Desarrollador"),
        DISENADORA("Diseñadora"),
        GERENTE("Gerente");

        private final String nombre;
        Cargo(String nombre) { this.nombre = nombre; }
        public String getNombre() { return nombre; }
        public static boolean existe(String nombre) {
            return Arrays.stream(values()).anyMatch(c -> c.getNombre().equalsIgnoreCase(nombre));
        }
    }
}

public class EmpleadoTest {

    private static final double SALARIO_CONVENIO = 15000.0;

    // Método de validación según criterios de TESTING.md
    private String validarEmpleado(String nombre, String puesto, Double salario) {
        if (nombre == null || nombre.trim().isEmpty())
            return "Nombre vacío";
        if (nombre.trim().split("\\s+").length < 2)
            return "Nombre con solo una palabra";
        if (puesto == null || puesto.trim().isEmpty())
            return "Puesto vacío";
        if (!Cargos.Cargo.existe(puesto))
            return "Puesto no definido";
        if (salario == null)
            return "Salario nulo";
        if (salario < 0)
            return "Salario negativo";
        if (salario < SALARIO_CONVENIO)
            return "Salario por debajo del convenio";
        return "OK";
    }

    // Casos válidos
    @Test
    void testV1() {
        assertEquals("OK", validarEmpleado("Juan Pérez", "Desarrollador", 20000.0));
    }

    @Test
    void testV2() {
        assertEquals("OK", validarEmpleado("Ana María", "Diseñadora", 15000.0));
    }

    @Test
    void testV3() {
        assertEquals("OK", validarEmpleado("Pedro García", "Gerente", 50000.0));
    }

    @Test
    void testV4() {
        assertEquals("OK", validarEmpleado("María López Ruiz", "Diseñadora", 18000.0));
    }

    @Test
    void testV5() {
        assertEquals("OK", validarEmpleado("Luis Miguel", "Desarrollador", 15000.5));
    }

    // Casos no válidos
    @Test
    void testN1() {
        assertEquals("Nombre vacío", validarEmpleado("", "Desarrollador", 20000.0));
    }

    @Test
    void testN2() {
        assertEquals("Nombre con solo una palabra", validarEmpleado("Juan", "Gerente", 20000.0));
    }

    @Test
    void testN3() {
        assertEquals("Nombre vacío", validarEmpleado(null, "Diseñadora", 20000.0));
    }

    @Test
    void testN4() {
        assertEquals("Puesto no definido", validarEmpleado("Ana María", "dev", 20000.0));
    }

    @Test
    void testN5() {
        assertEquals("Puesto vacío", validarEmpleado("Pedro García", "", 20000.0));
    }

    @Test
    void testN6() {
        assertEquals("Salario negativo", validarEmpleado("Juan Pérez", "Gerente", -100.0));
    }

    @Test
    void testN7() {
        assertEquals("Salario por debajo del convenio", validarEmpleado("Ana María", "Diseñadora", 14999.0));
    }

    @Test
    void testN8() {
        // Solo se comprueba el primer error encontrado
        String res = validarEmpleado("Juan", "jefe", 10000.0);
        List<String> posibles = Arrays.asList("Nombre con solo una palabra", "Puesto no definido", "Salario por debajo del convenio");
        assertTrue(posibles.contains(res));
    }

    @Test
    void testN9() {
        String res = validarEmpleado(null, null, null);
        List<String> posibles = Arrays.asList("Nombre vacío", "Puesto vacío", "Salario nulo");
        assertTrue(posibles.contains(res));
    }
}
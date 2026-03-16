/**
 * Clase que gestiona los cargos profesionales posibles en la empresa.
 */
public class Cargos {
    /**
     * Enum que representa los cargos válidos.
     */
    public enum Cargo {
        DESARROLLADOR("Desarrollador"),
        DISENADORA("Diseñadora"),
        GERENTE("Gerente");

        /**
         * Nombre legible del cargo.
         */
        private final String nombre;

        /**
         * Constructor del enum Cargo.
         * @param nombre Nombre legible del cargo.
         */
        Cargo(String nombre) {
            this.nombre = nombre;
        }

        /**
         * Devuelve el nombre legible del cargo.
         * @return Nombre del cargo.
         */
        public String getNombre() {
            return nombre;
        }

        /**
         * Busca un cargo por su nombre (ignorando mayúsculas/minúsculas y espacios).
         * @param nombre Nombre a buscar.
         * @return Cargo correspondiente o null si no existe.
         */
        public static Cargo fromNombre(String nombre) {
            for (Cargo c : Cargo.values()) {
                if (c.getNombre().equalsIgnoreCase(nombre.trim())) {
                    return c;
                }
            }
            return null;
        }
    }
}
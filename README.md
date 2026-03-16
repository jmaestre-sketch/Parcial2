# ExamenEntornosPractica

## Información general

Este proyecto es una aplicación Java de consola para la gestión básica de empleados en una empresa. Permite dar de alta empleados, listar los empleados actuales y aumentar el salario de todos ellos en un porcentaje indicado por el usuario. El sistema utiliza buenas prácticas de encapsulamiento, validación y separación de responsabilidades.

## Estructura del código

- **SistemaGestionEmpleados.java**  
  Contiene el método `main` y la lógica principal de interacción con el usuario. Utiliza la clase `Empleados` para gestionar la colección de empleados.

- **Empleados.java**  
  Clase que encapsula la gestión de un array de empleados, incluyendo métodos para alta, listado y aumento de salario.

- **Empleado.java**  
  Clase que representa a un empleado, con atributos privados y métodos getter/setter para nombre, puesto y salario.

- **Cargos.java**  
  Enum que define los cargos profesionales válidos en la empresa, evitando errores por escritura libre de textos.

- **ConstantesUI.java**  
  Clase de utilidades que centraliza todos los textos fijos y números mágicos usados en la interfaz, facilitando la traducción y el mantenimiento.

- **EmpleadoTest.java**  
  Conjunto de pruebas unitarias JUnit 5 que validan los criterios de aceptación de los atributos de la clase `Empleado` mediante testing de caja negra.

- **TESTING.md**  
  Documento que recoge el análisis de caja negra realizado sobre los atributos de la clase `Empleado`, incluyendo criterios de aceptación y tablas de casos válidos y no válidos.

## Ejecución

Compila y ejecuta el proyecto desde la terminal con:

```sh
javac *.java
java SistemaGestionEmpleados
```

## Testing

Las pruebas unitarias están implementadas en JUnit 5 en el archivo `EmpleadoTest.java`. Para ejecutarlas, usa tu entorno de desarrollo o una herramienta compatible con JUnit 5.

## Autoría

- **Autor:** [Tu Nombre Aquí]
- **Versión:** 1.0
- **Fecha:** Marzo 2026

## Licencia

Este proyecto es solo para fines educativos y de prácticas de programación en entornos
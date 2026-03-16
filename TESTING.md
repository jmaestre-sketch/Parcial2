# TESTING — Análisis de caja negra para la clase Empleado

Suposición: El salario mínimo por convenio es 15.000.

---

## 1. Análisis de los parámetros

| Parámetro | Tipo esperado | Criterio de aceptación | Ejemplos válidos | Ejemplos no válidos |
|-----------|--------------|------------------------|------------------|---------------------|
| nombre    | String       | No vacío, al menos dos palabras separadas por espacio | "Juan Pérez", "Ana María" | "", "Juan", null |
| puesto    | String       | Debe coincidir exactamente con uno de los cargos definidos en la clase Cargos | "Desarrollador", "Diseñadora", "Gerente" | "dev", "Jefe", "", null |
| salario   | double       | No nulo, no negativo, igual o superior a 15.000 | 15000, 20000, 50000 | -100, 0, 14999, null |

---

## 2. Casos válidos

| ID | Nombre           | Puesto         | Salario | Resultado esperado         | Observaciones                  |
|----|------------------|---------------|---------|---------------------------|--------------------------------|
| V1 | Juan Pérez       | Desarrollador | 20000   | Aceptado                  | Caso nominal                   |
| V2 | Ana María        | Diseñadora    | 15000   | Aceptado                  | Salario igual al convenio      |
| V3 | Pedro García     | Gerente       | 50000   | Aceptado                  | Salario alto                   |
| V4 | María López Ruiz | Diseñadora    | 18000   | Aceptado                  | Nombre con más de dos palabras |
| V5 | Luis Miguel      | Desarrollador | 15000.5 | Aceptado                  | Salario decimal                |

---

## 3. Casos no válidos

| ID | Nombre      | Puesto         | Salario | Motivo de rechazo                        | Resultado esperado |
|----|-------------|---------------|---------|------------------------------------------|-------------------|
| N1 | ""          | Desarrollador | 20000   | Nombre vacío                             | Rechazo           |
| N2 | Juan        | Gerente       | 20000   | Nombre con solo una palabra              | Rechazo           |
| N3 | null        | Diseñadora    | 20000   | Nombre nulo                              | Rechazo           |
| N4 | Ana María   | dev           | 20000   | Puesto no definido en Cargos             | Rechazo           |
| N5 | Pedro García| ""            | 20000   | Puesto vacío                             | Rechazo           |
| N6 | Juan Pérez  | Gerente       | -100    | Salario negativo                         | Rechazo           |
| N7 | Ana María   | Diseñadora    | 14999   | Salario por debajo del convenio          | Rechazo           |
| N8 | Juan        | jefe          | 10000   | Nombre insuficiente, puesto incorrecto, salario bajo | Rechazo múltiple  |
| N9 | null        | null          | null    | Todos los campos nulos                   | Rechazo múltiple  |

---

**Notas:**
- El análisis se basa en los criterios de aceptación definidos arriba.
- Para cada caso no válido, el sistema debe indicar claramente el motivo del rechazo.
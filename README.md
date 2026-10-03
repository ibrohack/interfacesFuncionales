# Interfaces funcionales y clases anónimas
Aritz Navarro - Brayan Romero - Ivan Vivanco

## Repositorio GitHub
Repositorio: https://github.com/ibrohack/interfacesFuncionales

## Estructura
- `interfaces1/ejercicio1` – Reescritura con clases anónimas (`Predicate`, `Function`, `Consumer`).
- `interfaces1/ejercicio2` – Gestión de pedidos: `Pedido`, `GestorPedidos` y `Main`. Incluye el apartado 4, la interfaz funcional genérica propia `Calculador<T,R>`, usada con clase anónima y con lambda.

## Compilar y ejecutar (Java 17+)
Desde la raíz del proyecto:

```
javac -encoding UTF-8 -d out interfaces1/ejercicio1/*.java interfaces1/ejercicio2/*.java
java -cp out interfaces1.ejercicio1.Ejercicio1
java -cp out interfaces1.ejercicio2.Main
```

## Ejercicio 2 – Pregunta
**¿Qué ventaja tiene que `buscar()` reciba un `Predicate` en lugar de tener un método por cada criterio?**

- Un único método `buscar()` sirve para cualquier criterio de búsqueda: añadir un criterio nuevo no obliga a modificar `GestorPedidos` (abierto a la extensión, cerrado a la modificación).
- Se evita una explosión de métodos (`buscarMayoresDe1000`, `buscarNoPagados`, ...) y el código duplicado del recorrido y el filtrado.
- El comportamiento se pasa como parámetro, lo que facilita reutilizarlo, probarlo y combinarlo (`and`, `or`, `negate`).

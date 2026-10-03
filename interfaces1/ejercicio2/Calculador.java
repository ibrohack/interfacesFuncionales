package interfaces1.ejercicio2;

import java.util.List;

/**
 * Interfaz funcional genérica propia: reduce una lista de elementos de tipo T
 * a un único resultado de tipo R (un total, una media, un máximo...).
 * Es funcional porque tiene un único método abstracto; @FunctionalInterface
 * hace que el compilador lo compruebe.
 */
@FunctionalInterface
public interface Calculador<T, R> {
    R calcular(List<T> elementos);
}

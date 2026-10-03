package interfaces1.ejercicio1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ejercicio1 {

    public static void main(String[] args) {
        // 1.1 Predicate<Integer>: ¿es mayor de edad?
        Predicate<Integer> p = new Predicate<Integer>() {
            @Override
            public boolean test(Integer edad) {
                return edad >= 18;
            }
        };
        System.out.println(p.test(20));

        // 1.2 Function<String, Integer>: longitud del texto
        Function<String, Integer> longitud = new Function<String, Integer>() {
            @Override
            public Integer apply(String texto) {
                return texto.length();
            }
        };
        System.out.println(longitud.apply("Hola"));

        // 1.3 Consumer<String>: mostrar el texto
        Consumer<String> mostrar = new Consumer<String>() {
            @Override
            public void accept(String texto) {
                System.out.println(texto);
            }
        };
        mostrar.accept("Hola");
    }
}

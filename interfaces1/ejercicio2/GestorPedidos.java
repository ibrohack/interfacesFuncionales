package interfaces1.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class GestorPedidos {

    /** Devuelve los pedidos que cumplen la condición recibida. */
    public List<Pedido> buscar(List<Pedido> pedidos, Predicate<Pedido> condicion) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (condicion.test(pedido)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    /** Aplica la transformación recibida al pedido y devuelve el String resultante. */
    public String transformar(Pedido pedido, Function<Pedido, String> transformacion) {
        return transformacion.apply(pedido);
    }

    /** Ejecuta la acción recibida sobre cada pedido. */
    public void procesar(List<Pedido> pedidos, Consumer<Pedido> accion) {
        for (Pedido pedido : pedidos) {
            accion.accept(pedido);
        }
    }

    /** Reduce la lista de pedidos a un valor mediante el cálculo recibido. */
    public <R> R calcular(List<Pedido> pedidos, Calculador<Pedido, R> calculador) {
        return calculador.calcular(pedidos);
    }
}

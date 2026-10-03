package interfaces1.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido(1, "Ana", 1200, true));
        pedidos.add(new Pedido(2, "Carlos", 350, false));
        pedidos.add(new Pedido(3, "Marta", 800, true));
        pedidos.add(new Pedido(4, "Luis", 1500, false));

        GestorPedidos gestor = new GestorPedidos();

        // 1. Buscar pedidos
        System.out.println("--- Pedidos con importe superior a 1000 ---");
        List<Pedido> caros = gestor.buscar(pedidos, new Predicate<Pedido>() {
            @Override
            public boolean test(Pedido pedido) {
                return pedido.getImporte() > 1000;
            }
        });
        for (Pedido p : caros) {
            System.out.println(p);
        }

        System.out.println("--- Pedidos sin pagar ---");
        List<Pedido> sinPagar = gestor.buscar(pedidos, new Predicate<Pedido>() {
            @Override
            public boolean test(Pedido pedido) {
                return !pedido.isPagado();
            }
        });
        for (Pedido p : sinPagar) {
            System.out.println(p);
        }

        // 2. Transformar pedidos
        Function<Pedido, String> aCsv = new Function<Pedido, String>() {
            @Override
            public String apply(Pedido pedido) {
                return pedido.getNumero() + ";" + pedido.getCliente() + ";"
                        + pedido.getImporte() + ";" + pedido.isPagado();
            }
        };
        Function<Pedido, String> aDescripcion = new Function<Pedido, String>() {
            @Override
            public String apply(Pedido pedido) {
                return "Pedido " + pedido.getNumero() + " - Cliente: " + pedido.getCliente()
                        + " - Importe: " + pedido.getImporte() + " €";
            }
        };

        System.out.println("--- Transformaciones del primer pedido ---");
        System.out.println(gestor.transformar(pedidos.get(0), aCsv));
        System.out.println(gestor.transformar(pedidos.get(0), aDescripcion));

        // 3. Procesar pedidos
        System.out.println("--- Número y cliente de cada pedido ---");
        gestor.procesar(pedidos, new Consumer<Pedido>() {
            @Override
            public void accept(Pedido pedido) {
                System.out.println(pedido.getNumero() + " - " + pedido.getCliente());
            }
        });

        System.out.println("--- Avisos de pedidos sin pagar ---");
        gestor.procesar(pedidos, new Consumer<Pedido>() {
            @Override
            public void accept(Pedido pedido) {
                if (!pedido.isPagado()) {
                    System.out.println("AVISO: el pedido " + pedido.getNumero()
                            + " de " + pedido.getCliente() + " está pendiente de pago");
                }
            }
        });

        // 4. Interfaz funcional genérica propia: Calculador<T, R>
        // Con clase anónima: facturación de los pedidos ya pagados
        Calculador<Pedido, Double> totalCobradoAnonimo = new Calculador<Pedido, Double>() {
            @Override
            public Double calcular(List<Pedido> elementos) {
                double total = 0;
                for (Pedido pedido : elementos) {
                    if (pedido.isPagado()) {
                        total += pedido.getImporte();
                    }
                }
                return total;
            }
        };
        System.out.println("--- Calculador genérico ---");
        System.out.println("Total cobrado (clase anónima): "
                + gestor.calcular(pedidos, totalCobradoAnonimo));

        // Sin clase anónima (lambda): el mismo cálculo
        Calculador<Pedido, Double> totalCobradoLambda = elementos -> {
            double total = 0;
            for (Pedido pedido : elementos) {
                if (pedido.isPagado()) {
                    total += pedido.getImporte();
                }
            }
            return total;
        };
        System.out.println("Total cobrado (lambda): "
                + gestor.calcular(pedidos, totalCobradoLambda));

        // Mismo interfaz con otro tipo de resultado (String): cliente con mayor importe
        Calculador<Pedido, String> clienteMayorImporte = elementos -> {
            Pedido mayor = elementos.get(0);
            for (Pedido pedido : elementos) {
                if (pedido.getImporte() > mayor.getImporte()) {
                    mayor = pedido;
                }
            }
            return mayor.getCliente();
        };
        System.out.println("Cliente con mayor importe: "
                + gestor.calcular(pedidos, clienteMayorImporte));
    }
}

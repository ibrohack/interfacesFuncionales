package interfaces1.ejercicio2;

public class Pedido {
    private int numero;
    private String cliente;
    private double importe;
    private boolean pagado;

    public Pedido(int numero, String cliente,
                  double importe, boolean pagado) {
        this.numero = numero;
        this.cliente = cliente;
        this.importe = importe;
        this.pagado = pagado;
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public double getImporte() {
        return importe;
    }

    public boolean isPagado() {
        return pagado;
    }

    @Override
    public String toString() {
        return "Pedido{numero=" + numero + ", cliente='" + cliente
                + "', importe=" + importe + ", pagado=" + pagado + "}";
    }
}

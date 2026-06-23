package FoodStore.entities;

public class DetallePedido extends Base {

    private Integer cantidad;

    private Double subtotal;

    private Producto producto;

    public DetallePedido(Long id, Integer cantidad, Producto producto) {

        super(id);

        this.cantidad = cantidad;
        this.producto = producto;

        calcularSubtotal();
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(
            Integer cantidad) {

        this.cantidad = cantidad;

        calcularSubtotal();
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Producto getProducto() {
        return producto;
    }

    /**
     * Calcula el subtotal del detalle.
     */
    public void calcularSubtotal() {

        subtotal =
                cantidad *
                producto.getPrecio();
    }

    @Override
    public String toString() {

        return "DetallePedido{" +
                "id=" + getId() +
                ", producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                ", subtotal=" + subtotal +
                '}';
    }
}
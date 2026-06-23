package FoodStore.entities;

import FoodStore.enums.Estado;
import FoodStore.enums.FormaPago;
import FoodStore.interfaces.Calculable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa un pedido realizado por un usuario.
 */
public class Pedido extends Base implements Calculable {

    private LocalDate fecha;

    private Estado estado;

    private FormaPago formaPago;

    private Double total;

    private Usuario usuario;

    private ArrayList<DetallePedido> detalles;

    public Pedido(Long id, Usuario usuario, FormaPago formaPago) {

        super(id);

        this.usuario = usuario;

        this.formaPago = formaPago;

        this.estado =
                Estado.PENDIENTE;

        this.fecha =
                LocalDate.now();

        this.total = 0.0;

        detalles =
                new ArrayList<>();
    }

    /**
     * Agrega un producto al pedido.
     */
    public void addDetallePedido(Integer cantidad, Producto producto) {

        DetallePedido detalle =
                new DetallePedido(
                        Long.valueOf(
                                detalles.size() + 1),
                        cantidad,
                        producto);

        detalles.add(detalle);

        calcularTotal();
    }

    /**
     * Busca un detalle por producto.
     */
    public DetallePedido findDetallePedidoByProducto(Producto producto) {

        for (DetallePedido detalle :
                detalles) {

            if (detalle.getProducto()
                    .getId()
                    .equals(
                            producto.getId())) {

                return detalle;
            }
        }

        return null;
    }

    /**
     * Elimina un detalle del pedido.
     */
    public void deleteDetallePedidoByProducto(Producto producto) {

        DetallePedido detalle =
                findDetallePedidoByProducto(
                        producto);

        if (detalle != null) {

            detalles.remove(detalle);

            calcularTotal();
        }
    }

    /**
     * Recalcula el total del pedido.
     */
    @Override
    public void calcularTotal() {

        total = 0.0;

        for (DetallePedido detalle :
                detalles) {

            total +=
                    detalle.getSubtotal();
        }
    }

    public Double getTotal() {
        return total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Estado getEstado() {
        return estado;
    }
    
    public void setEstado(
        Estado estado) {

    this.estado = estado;
}

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public ArrayList<DetallePedido>
            getDetalles() {

        return detalles;
    }

    /**
     * Muestra todos los detalles del pedido.
     */
    public void mostrarDetalles() {

        for (DetallePedido detalle :
                detalles) {

            System.out.println(
                    detalle);
        }
    }

    @Override
    public String toString() {

        return "Pedido{" +
                "id=" + getId() +
                ", fecha=" + fecha +
                ", estado=" + estado +
                ", formaPago=" + formaPago +
                ", total=" + total +
                ", usuario=" +
                usuario.getNombre() +
                '}';
    }
}
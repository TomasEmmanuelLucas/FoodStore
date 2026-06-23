package FoodStore.services;

import FoodStore.entities.Pedido;
import FoodStore.entities.Producto;
import FoodStore.entities.Usuario;
import FoodStore.enums.Estado;
import FoodStore.enums.FormaPago;
import FoodStore.exceptions.EntidadNoEncontradaException;
import java.util.ArrayList;

public class PedidoService {

    private ArrayList<Pedido> pedidos;

    private Long contadorId;

    public PedidoService() {

        pedidos = new ArrayList<>();

        contadorId = 1L;
    }

    public void crearPedido(
            Usuario usuario,
            FormaPago formaPago) {

        Pedido pedido =
                new Pedido(
                        contadorId++,
                        usuario,
                        formaPago);

        pedidos.add(pedido);
    }

    public Pedido buscarPedidoPorId(
            Long id)
            throws EntidadNoEncontradaException {

        for (Pedido pedido : pedidos) {

            if (pedido.getId().equals(id)
                    && !pedido.isEliminado()) {

                return pedido;
            }
        }

        throw new EntidadNoEncontradaException(
                "Pedido no encontrado.");
    }

    public void agregarProductoAPedido(
            Long idPedido,
            Integer cantidad,
            Producto producto)
            throws EntidadNoEncontradaException {

        Pedido pedido =
                buscarPedidoPorId(idPedido);

        pedido.addDetallePedido(
                cantidad,
                producto);
    }

    public void cambiarEstadoPedido(
            Long idPedido,
            Estado nuevoEstado)
            throws EntidadNoEncontradaException {

        Pedido pedido =
                buscarPedidoPorId(idPedido);

        pedido.setEstado(
                nuevoEstado);
    }

    public void eliminarPedido(
            Long idPedido)
            throws EntidadNoEncontradaException {

        Pedido pedido =
                buscarPedidoPorId(
                        idPedido);

        pedido.setEliminado(true);
    }

    public ArrayList<Pedido>
            buscarPedidosPorUsuario(
                    Usuario usuario) {

        ArrayList<Pedido> resultado =
                new ArrayList<>();

        for (Pedido pedido : pedidos) {

            if (pedido.getUsuario()
                    .getId()
                    .equals(usuario.getId())
                    && !pedido.isEliminado()) {

                resultado.add(pedido);
            }
        }

        return resultado;
    }

    public void listarPedidos() {

        for (Pedido pedido : pedidos) {

            if (!pedido.isEliminado()) {

                System.out.println(
                        pedido);
            }
        }
    }

    public ArrayList<Pedido>
            getPedidos() {

        return pedidos;
    }
}
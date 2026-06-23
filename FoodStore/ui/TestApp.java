package FoodStore.ui;

import FoodStore.entities.Pedido;
import FoodStore.entities.Usuario;
import FoodStore.enums.Estado;
import FoodStore.enums.FormaPago;
import FoodStore.enums.Rol;
import FoodStore.exceptions.EmailDuplicadoException;
import FoodStore.exceptions.EntidadNoEncontradaException;
import FoodStore.exceptions.StockInvalidoException;
import FoodStore.services.CategoriaService;
import FoodStore.services.PedidoService;
import FoodStore.services.ProductoService;
import FoodStore.services.UsuarioService;

public class TestApp {

    public static void main(String[] args) {

        CategoriaService categoriaService =
                new CategoriaService();

        ProductoService productoService =
                new ProductoService();

        UsuarioService usuarioService =
                new UsuarioService();

        PedidoService pedidoService =
                new PedidoService();

        try {

            // ==========================
            // CATEGORIAS
            // ==========================

            categoriaService.crearCategoria(
                    "Bebidas",
                    "Gaseosas y jugos");

            categoriaService.crearCategoria(
                    "Comidas",
                    "Comidas rapidas");

            System.out.println(
                    "\n===== CATEGORIAS =====");

            categoriaService.listarCategorias();

            // ==========================
            // PRODUCTOS
            // ==========================

            productoService.crearProducto(
                    "Coca Cola",
                    "Gaseosa cola",
                    1500.0,
                    20,
                    "cocacola.jpg",
                    categoriaService.buscarCategoriaPorId(1L));

            productoService.crearProducto(
                    "Sprite",
                    "Gaseosa lima limon",
                    1400.0,
                    10,
                    "sprite.jpg",
                    categoriaService.buscarCategoriaPorId(1L));

            System.out.println(
                    "\n===== PRODUCTOS =====");

            productoService.listarProductos();

            // ==========================
            // USUARIOS
            // ==========================

            usuarioService.crearUsuario(
                    "Tomas",
                    "Lucas",
                    "tomas@gmail.com",
                    "2804123456",
                    "1234",
                    Rol.ADMIN);

            usuarioService.crearUsuario(
                    "Juan",
                    "Perez",
                    "juan@gmail.com",
                    "2804555555",
                    "5678",
                    Rol.USUARIO);

            System.out.println(
                    "\n===== USUARIOS =====");

            usuarioService.listarUsuarios();

            // ==========================
            // PEDIDOS
            // ==========================

            Usuario usuario =
                    usuarioService.buscarUsuarioPorId(
                            1L);

            pedidoService.crearPedido(
                    usuario,
                    FormaPago.TARJETA);

            pedidoService.agregarProductoAPedido(
                    1L,
                    2,
                    productoService.buscarProductoPorId(
                            1L));

            pedidoService.agregarProductoAPedido(
                    1L,
                    1,
                    productoService.buscarProductoPorId(
                            2L));

            System.out.println(
                    "\n===== PEDIDOS =====");

            pedidoService.listarPedidos();

            System.out.println(
                    "\n===== DETALLES PEDIDO =====");

            pedidoService.buscarPedidoPorId(
                    1L)
                    .mostrarDetalles();

            // ==========================
            // CAMBIO DE ESTADO
            // ==========================

            System.out.println(
                    "\n===== CAMBIO DE ESTADO =====");

            pedidoService.cambiarEstadoPedido(
                    1L,
                    Estado.CONFIRMADO);

            pedidoService.listarPedidos();

            // ==========================
            // BUSQUEDA POR USUARIO
            // ==========================

            System.out.println(
                    "\n===== BUSQUEDA POR USUARIO =====");

            Usuario usuarioBuscado =
                    usuarioService.buscarUsuarioPorId(
                            1L);

            for (Pedido pedido :
                    pedidoService.buscarPedidosPorUsuario(
                            usuarioBuscado)) {

                System.out.println(
                        pedido);
            }

            // ==========================
            // ELIMINACION LOGICA
            // ==========================

            System.out.println(
                    "\n===== ELIMINACION PEDIDO =====");

            pedidoService.eliminarPedido(
                    1L);

            pedidoService.listarPedidos();

        } catch (
                EntidadNoEncontradaException
                | StockInvalidoException
                | EmailDuplicadoException e) {

            System.out.println(
                    "ERROR: "
                    + e.getMessage());
        }
    }
}
package FoodStore.ui;

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
import java.util.Scanner;

public class Main {
    
    private static CategoriaService categoriaService = new CategoriaService();
    private static ProductoService productoService = new ProductoService();
    private static UsuarioService usuarioService = new UsuarioService();
    private static PedidoService pedidoService = new PedidoService();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {

            System.out.println("\n===== FOOD STORE =====");

            System.out.println("1. Categorias");

            System.out.println("2. Productos");

            System.out.println("3. Usuarios");

            System.out.println("4. Pedidos");

            System.out.println("0. Salir");

            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            
            scanner.nextLine();

            switch (opcion) {

    case 1:

        menuCategorias(scanner);

        break;

    case 2:

        menuProductos(scanner);

        break;

    case 3:

        menuUsuarios(scanner);

    break;

    case 4:

    menuPedidos(scanner);

    break;

    case 0:

        System.out.println("Saliendo...");

        break;

    default:

        System.out.println("Opcion invalida");
}

        } while (opcion != 0);

        scanner.close();
    }
    public static void menuCategorias(Scanner scanner) {

    int opcion;

    do {

        System.out.println("\n===== MENU CATEGORIAS =====");

        System.out.println("1. Crear categoria");

        System.out.println("2. Listar categorias");

        System.out.println("3. Buscar categoria");

        System.out.println("4. Actualizar categoria");

        System.out.println("5. Eliminar categoria");

        System.out.println("0. Volver");

        System.out.print("Seleccione una opcion: ");

        opcion =
                scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {

            case 1:

                System.out.print("Nombre: ");

                String nombre = scanner.nextLine();

                System.out.print("Descripcion: ");

                String descripcion = scanner.nextLine();

                categoriaService.crearCategoria(nombre, descripcion);

                System.out.println("Categoria creada.");

                break;

            case 2:

                categoriaService.listarCategorias();

                break;

            case 3:

                try {

                    System.out.print("ID de la categoria: ");

                    Long idBuscar = scanner.nextLong();

                    scanner.nextLine();

                    System.out.println(categoriaService.buscarCategoriaPorId(idBuscar));

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 4:

                try {

                    System.out.print("ID de la categoria: ");

                    Long idActualizar = scanner.nextLong();

                    scanner.nextLine();

                    System.out.print("Nuevo nombre: ");

                    String nuevoNombre = scanner.nextLine();

                    System.out.print("Nueva descripcion: ");

                    String nuevaDescripcion = scanner.nextLine();

                    categoriaService.actualizarCategoria(idActualizar,nuevoNombre,nuevaDescripcion);

                    System.out.println(
                            "Categoria actualizada.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 5:

                try {

                    System.out.print("ID de la categoria: ");

                    Long idEliminar = scanner.nextLong();

                    scanner.nextLine();

                    categoriaService.eliminarCategoria(idEliminar);

                    System.out.println("Categoria eliminada.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 0:

                break;

            default:

                System.out.println("Opcion invalida.");
        }

    } while (opcion != 0);
}
    public static void menuProductos(
        Scanner scanner) {

    int opcion;

    do {

        System.out.println("\n===== MENU PRODUCTOS =====");

        System.out.println("1. Crear producto");

        System.out.println("2. Listar productos");

        System.out.println("3. Buscar producto");

        System.out.println("4. Eliminar producto");

        System.out.println("0. Volver");

        System.out.print("Seleccione una opcion: ");

        opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {

            case 1:

                try {

                    System.out.print("Nombre: ");

                    String nombre = scanner.nextLine();

                    System.out.print("Descripcion: ");

                    String descripcion = scanner.nextLine();

                    System.out.print("Precio: ");

                    Double precio = scanner.nextDouble();

                    System.out.print("Stock: ");

                    Integer stock = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Imagen: ");

                    String imagen = scanner.nextLine();

                    System.out.print("ID Categoria: ");

                    Long idCategoria = scanner.nextLong();

                    scanner.nextLine();

                    productoService.crearProducto(nombre,descripcion,precio,stock,imagen,categoriaService.buscarCategoriaPorId(idCategoria));

                    System.out.println(
                            "Producto creado.");

                } catch (StockInvalidoException| EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 2:

                productoService.listarProductos();

                break;

            case 3:

                try {

                    System.out.print("ID Producto: ");

                    Long id = scanner.nextLong();

                    scanner.nextLine();

                    System.out.println(productoService.buscarProductoPorId(id));

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 4:

                try {

                    System.out.print("ID Producto: ");

                    Long id = scanner.nextLong();

                    scanner.nextLine();

                    productoService.eliminarProducto(id);

                    System.out.println("Producto eliminado.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 0:

                break;

            default:

                System.out.println("Opcion invalida.");
        }

    } while (opcion != 0);
}
    public static void menuUsuarios(Scanner scanner) {

    int opcion;

    do {

        System.out.println("\n===== MENU USUARIOS =====");

        System.out.println("1. Crear usuario");

        System.out.println("2. Listar usuarios");

        System.out.println("3. Buscar usuario");

        System.out.println("4. Eliminar usuario");

        System.out.println("0. Volver");

        System.out.print("Seleccione una opcion: ");

        opcion =  scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {

            case 1:

            try {

                System.out.print("Nombre: ");

                String nombre = scanner.nextLine();

                System.out.print("Apellido: ");

                String apellido = scanner.nextLine();

                System.out.print("Email: ");

                String email = scanner.nextLine();

                System.out.print("Celular: ");

                String celular = scanner.nextLine();

                System.out.print("Password: ");

                String password = scanner.nextLine();

                System.out.println("1. ADMIN");

                System.out.println("2. USUARIO");

                System.out.print("Rol: ");

                int opcionRol = scanner.nextInt();

                scanner.nextLine();

                if (opcionRol < 1
                        || opcionRol > 2) {

                    System.out.println(
                            "Opcion invalida.");

                    break;
                }

                Rol rol;

                if (opcionRol == 1) {

                    rol = Rol.ADMIN;

                } else {

                    rol = Rol.USUARIO;
                }

                usuarioService.crearUsuario(nombre,apellido,email,celular,password,rol);

                System.out.println("Usuario creado.");

            } catch (EmailDuplicadoException e) {

                System.out.println(e.getMessage());
            }

            break;

            case 2:

                usuarioService.listarUsuarios();

                break;

            case 3:

                try {

                    System.out.print("ID Usuario: ");

                    Long id = scanner.nextLong();

                    scanner.nextLine();

                    System.out.println(usuarioService.buscarUsuarioPorId(id));

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 4:

                try {

                    System.out.print("ID Usuario: ");

                    Long id = scanner.nextLong();

                    scanner.nextLine();

                    usuarioService.eliminarUsuario(id);

                    System.out.println("Usuario eliminado.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 0:

                break;

            default:

                System.out.println("Opcion invalida.");
        }

    } while (opcion != 0);
}
    public static void menuPedidos(Scanner scanner) {

    int opcion;

    do {

        System.out.println("\n===== MENU PEDIDOS =====");

        System.out.println("1. Crear pedido");

        System.out.println("2. Agregar producto");

        System.out.println("3. Listar pedidos");

        System.out.println("4. Cambiar estado");

        System.out.println("5. Eliminar pedido");

        System.out.println("0. Volver");

        System.out.print("Seleccione una opcion: ");

        opcion = scanner.nextInt();

        scanner.nextLine();

        switch (opcion) {

            case 1:

                try {

                    System.out.print("ID Usuario: ");

                    Long idUsuario = scanner.nextLong();

                    scanner.nextLine();

                    System.out.println("1. EFECTIVO");

                    System.out.println("2. TARJETA");

                    System.out.println("3. TRANSFERENCIA");

                    System.out.print("Forma de pago: ");

                    int opcionPago = scanner.nextInt();

                    scanner.nextLine();

                    if (opcionPago < 1 || opcionPago > 3) {

                        System.out.println("Opcion invalida.");

                        break;
                    }

                    FormaPago formaPago;

                    switch (opcionPago) {

                        case 1:

                            formaPago = FormaPago.EFECTIVO;

                            break;

                        case 2:

                            formaPago = FormaPago.TARJETA;

                            break;

                        default:

                            formaPago = FormaPago.TRANSFERENCIA;
                    }

                    pedidoService.crearPedido(usuarioService.buscarUsuarioPorId(idUsuario),formaPago);

                    System.out.println("Pedido creado.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 2:

                try {

                    System.out.print("ID Pedido: ");

                    Long idPedido = scanner.nextLong();

                    System.out.print("ID Producto: ");

                    Long idProducto =scanner.nextLong();

                    System.out.print("Cantidad: ");

                    Integer cantidad = scanner.nextInt();

                    scanner.nextLine();

                    pedidoService.agregarProductoAPedido(idPedido,cantidad,productoService.buscarProductoPorId(idProducto));

                    System.out.println("Producto agregado.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 3:

                pedidoService.listarPedidos();

                break;

            case 4:

                try {

                    System.out.print("ID Pedido: ");

                    Long idPedido = scanner.nextLong();

                    scanner.nextLine();

                    System.out.println("1. PENDIENTE");

                    System.out.println("2. CONFIRMADO");

                    System.out.println("3. EN_PREPARACION");

                    System.out.println("4. ENVIADO");

                    System.out.println("5. ENTREGADO");

                    System.out.println("6. CANCELADO");

                    System.out.print("Seleccione el nuevo estado: ");

                    int opcionEstado = scanner.nextInt();

                    scanner.nextLine();

                    if (opcionEstado < 1 || opcionEstado > 6) {

                        System.out.println("Opcion invalida.");

                        break;
                    }

                    Estado estado;

                 switch (opcionEstado) {

                        case 1:

                            estado = Estado.PENDIENTE;

                            break;

                        case 2:

                            estado = Estado.CONFIRMADO;

                            break;

                        case 3:

                            estado = Estado.EN_PREPARACION;

                            break;

                        case 4:

                            estado = Estado.ENVIADO;

                            break;

                        case 5:

                            estado = Estado.ENTREGADO;

                            break;

                        default:

                            estado = Estado.CANCELADO;
                    }

                    pedidoService.cambiarEstadoPedido(idPedido,estado);

                    System.out.println("Estado actualizado.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 5:

                try {

                    System.out.print("ID Pedido: ");

                    Long idPedido = scanner.nextLong();

                    scanner.nextLine();

                    pedidoService.eliminarPedido(idPedido);

                    System.out.println("Pedido eliminado.");

                } catch (EntidadNoEncontradaException e) {

                    System.out.println(e.getMessage());
                }

                break;

            case 0:

                break;

            default:

                System.out.println("Opcion invalida.");
        }

    } while (opcion != 0);
}   
}
package FoodStore.services;

import FoodStore.entities.Categoria;
import FoodStore.entities.Producto;
import FoodStore.exceptions.EntidadNoEncontradaException;
import FoodStore.exceptions.StockInvalidoException;
import java.util.ArrayList;

public class ProductoService {

    private ArrayList<Producto> productos;

    private Long contadorId;

    public ProductoService() {

        productos = new ArrayList<>();

        contadorId = 1L;
    }

    public void crearProducto(
            String nombre,
            String descripcion,
            Double precio,
            Integer stock,
            String imagen,
            Categoria categoria)
            throws StockInvalidoException {
        
        if (precio < 0) {

            throw new StockInvalidoException("El precio no puede ser negativo.");
        }
        
        if (stock < 0) {

            throw new StockInvalidoException(
                    "El stock no puede ser negativo.");
        }

        Producto producto = new Producto(contadorId++,nombre,descripcion,precio,stock,imagen,categoria);

        productos.add(producto);
    }

    public void listarProductos() {

        for (Producto producto : productos) {

            if (!producto.isEliminado()) {

                System.out.println(producto);
            }
        }
    }

    public Producto buscarProductoPorId(
            Long id)
            throws EntidadNoEncontradaException {

        for (Producto producto : productos) {

            if (producto.getId().equals(id)
                    && !producto.isEliminado()) {

                return producto;
            }
        }

        throw new EntidadNoEncontradaException(
                "Producto no encontrado.");
    }

    public void actualizarProducto(
            Long id,
            String nombre,
            String descripcion,
            Double precio,
            Integer stock,
            String imagen)
            throws EntidadNoEncontradaException,
            StockInvalidoException {
        
        if (precio < 0) {

            throw new StockInvalidoException("El precio no puede ser negativo.");
        }
        if (stock < 0) {

            throw new StockInvalidoException(
                    "El stock no puede ser negativo.");
        }

        Producto producto =
                buscarProductoPorId(id);

        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setImagen(imagen);
    }

    public void eliminarProducto(
            Long id)
            throws EntidadNoEncontradaException {

        Producto producto = buscarProductoPorId(id);

        producto.setEliminado(true);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
}
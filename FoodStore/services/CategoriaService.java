package FoodStore.services;

import FoodStore.entities.Categoria;
import FoodStore.exceptions.EntidadNoEncontradaException;
import java.util.ArrayList;

/**
 * Servicio encargado de gestionar categorías.
 */
public class CategoriaService {

    private ArrayList<Categoria> categorias;

    private Long contadorId;

    public CategoriaService() {

        categorias = new ArrayList<>();

        contadorId = 1L;
    }

    /**
     * Crea una nueva categoría.
     */
    public void crearCategoria(
            String nombre,
            String descripcion) {

        Categoria categoria =
                new Categoria(
                        contadorId++,
                        nombre,
                        descripcion);

        categorias.add(categoria);
    }

    /**
     * Lista todas las categorías activas.
     */
    public void listarCategorias() {

        for (Categoria categoria :
                categorias) {

            if (!categoria.isEliminado()) {

                System.out.println(categoria);
            }
        }
    }

    /**
     * Busca una categoría por ID.
     */
    public Categoria buscarCategoriaPorId(
            Long id)
            throws EntidadNoEncontradaException {

        for (Categoria categoria :
                categorias) {

            if (categoria.getId().equals(id)
                    && !categoria.isEliminado()) {

                return categoria;
            }
        }

        throw new EntidadNoEncontradaException(
                "Categoria no encontrada.");
    }

    /**
     * Actualiza los datos de una categoría.
     */
    public void actualizarCategoria(
            Long id,
            String nombre,
            String descripcion)
            throws EntidadNoEncontradaException {

        Categoria categoria =
                buscarCategoriaPorId(id);

        categoria.setNombre(nombre);

        categoria.setDescripcion(descripcion);
    }

    /**
     * Baja lógica.
     */
    public void eliminarCategoria(
            Long id)
            throws EntidadNoEncontradaException {

        Categoria categoria = buscarCategoriaPorId(id);

        categoria.setEliminado(true);
    }

    public ArrayList<Categoria>
            getCategorias() {

        return categorias;
    }
}
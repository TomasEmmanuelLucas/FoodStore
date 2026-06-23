package FoodStore.entities;

/**
 * Representa un producto del sistema.
 */
public class Producto extends Base {

    private String nombre;

    private String descripcion;

    private Double precio;

    private Integer stock;

    private String imagen;

    private Categoria categoria;

    public Producto(Long id,String nombre,String descripcion,Double precio,Integer stock,String imagen,Categoria categoria) {

        super(id);

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(
            String nombre) {

        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(
            String descripcion) {

        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(
            Double precio) {

        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(
            Integer stock) {

        this.stock = stock;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(
            String imagen) {

        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(
            Categoria categoria) {

        this.categoria = categoria;
    }

    @Override
    public String toString() {

        return "Producto{" +
                "id=" + getId() +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoria=" +
                categoria.getNombre() +
                '}';
    }
}
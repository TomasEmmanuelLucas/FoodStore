package FoodStore.entities;

import FoodStore.enums.Rol;

/**
 * Representa un usuario del sistema.
 */
public class Usuario extends Base {

    private String nombre;

    private String apellido;

    private String email;

    private String celular;

    private String password;

    private Rol rol;

    public Usuario(Long id,String nombre,String apellido,String email,String celular,String password,Rol rol) {

        super(id);

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.password = password;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(
            String nombre) {

        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(
            String apellido) {

        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(
            String email) {

        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(
            String celular) {

        this.celular = celular;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(
            String password) {

        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(
            Rol rol) {

        this.rol = rol;
    }

    @Override
    public String toString() {

        return "Usuario{" +
                "id=" + getId() +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", rol=" + rol +
                '}';
    }
}
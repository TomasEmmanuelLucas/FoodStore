package FoodStore.services;

import FoodStore.entities.Usuario;
import FoodStore.enums.Rol;
import FoodStore.exceptions.EmailDuplicadoException;
import FoodStore.exceptions.EntidadNoEncontradaException;
import java.util.ArrayList;

public class UsuarioService {

    private ArrayList<Usuario> usuarios;

    private Long contadorId;

    public UsuarioService() {

        usuarios = new ArrayList<>();

        contadorId = 1L;
    }

    public void crearUsuario(
            String nombre,
            String apellido,
            String email,
            String celular,
            String password,
            Rol rol)
            throws EmailDuplicadoException {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail()
                    .equalsIgnoreCase(email)
                    && !usuario.isEliminado()) {

                throw new EmailDuplicadoException(
                        "Ya existe un usuario con ese email.");
            }
        }

        Usuario usuario =
                new Usuario(
                        contadorId++,
                        nombre,
                        apellido,
                        email,
                        celular,
                        password,
                        rol);

        usuarios.add(usuario);
    }

    public void listarUsuarios() {

        for (Usuario usuario : usuarios) {

            if (!usuario.isEliminado()) {

                System.out.println(usuario);
            }
        }
    }

    public Usuario buscarUsuarioPorId(
            Long id)
            throws EntidadNoEncontradaException {

        for (Usuario usuario : usuarios) {

            if (usuario.getId().equals(id)
                    && !usuario.isEliminado()) {

                return usuario;
            }
        }

        throw new EntidadNoEncontradaException(
                "Usuario no encontrado.");
    }

    public void actualizarUsuario(
            Long id,
            String nombre,
            String apellido,
            String email,
            String celular)
            throws EntidadNoEncontradaException {

        Usuario usuario =
                buscarUsuarioPorId(id);

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setCelular(celular);
    }

    public void eliminarUsuario(
            Long id)
            throws EntidadNoEncontradaException {

        Usuario usuario = buscarUsuarioPorId(id);

        usuario.setEliminado(true);
    }

    public ArrayList<Usuario> getUsuarios() {

        return usuarios;
    }
}
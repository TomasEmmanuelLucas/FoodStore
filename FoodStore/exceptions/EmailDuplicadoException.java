package FoodStore.exceptions;

public class EmailDuplicadoException
        extends Exception {

    public EmailDuplicadoException(
            String mensaje) {

        super(mensaje);
    }
}
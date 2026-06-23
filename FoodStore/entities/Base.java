package FoodStore.entities;

import java.time.LocalDateTime;

/**
 * Clase base para todas las entidades.
 */
public abstract class Base {

    private Long id;

    private boolean eliminado;

    private LocalDateTime createdAt;

    public Base(Long id) {

        this.id = id;

        this.eliminado = false;

        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public abstract String toString();
}
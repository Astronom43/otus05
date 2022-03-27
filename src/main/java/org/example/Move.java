package org.example;

/**
 * Ревлизация движения
 */
public class Move {
    private final Movable movable;

    /**
     * Публичный конструктор
     *
     * @param movable интерфейс для движущегося объекта
     */
    public Move(Movable movable) {
        this.movable = movable;
    }

    /**
     * выполнение движения
     */
    public void execute() {
        movable.setPosition(Vector.add(movable.getPosition(), movable.getVelocity()));
    }
}

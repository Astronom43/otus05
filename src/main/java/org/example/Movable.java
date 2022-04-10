package org.example;

/**
 * Interface для реализации движения движущигся объектов
 */
public interface Movable {
    /**
     * Получение позиции объекта
     *
     * @return позиция объекта
     */
    Vector getPosition();

    /**
     * Получение скорости объекта
     *
     * @return сокрость объекта
     */
    Vector getVelocity();

    /**
     * Задание позиции объекта
     *
     * @param newVector повая позиция
     */
    void setPosition(Vector newVector);
}

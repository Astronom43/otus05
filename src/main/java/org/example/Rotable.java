package org.example;

/**
 * Interface для реализации вращения вращающихся объектов
 */
public interface Rotable {
    /**
     * Получение информации о угле поворота и скорости вращения
     * @return информация о угле поворота и скорости вращения
     */
    Direction getDirection();

    /**
     * Задание информации о угле поворота и скорости вращения
     * @param next информация о угле поворота и скорости вращения
     */
    void setDirection(Direction next);
}

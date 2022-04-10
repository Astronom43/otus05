package org.example;

import static org.example.Direction.DIRECTION_NUMBER;

/**
 * Реализация вращения
 */
public class Rotate {
    private final Rotable rotable;

    /**
     * Публичный коструктор
     *
     * @param rotable интерфейс для вращающегося объекта
     */
    public Rotate(Rotable rotable) {
        this.rotable = rotable;
    }

    /**
     * Реализайия вращения
     */
    public void execute() {
        rotable.setDirection(next(rotable.getDirection().getAngle(), rotable.getDirection().getAngularVelocity()));
    }

    /**
     * Метод расчета следующего значения направления
     *
     * @param angle           текущий угол поворота в градусах
     * @param angularVelocity скорость поворота в градусах / 1 действие
     * @return Объект, содержащий информацию о направлении и скорости вращения
     */
    public static Direction next(int angle, int angularVelocity) {
        return new Direction(calculateAngle(angle, angularVelocity), angularVelocity);
    }

    private static int calculateAngle(int angle, int angularVelocity) {
        final int i = (angle + angularVelocity) % DIRECTION_NUMBER;
        return i >= 0 ? i : DIRECTION_NUMBER + i;
    }
}

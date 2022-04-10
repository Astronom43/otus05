package org.example;

import java.util.Optional;

/**
 * Класс для хранения информации о текущем расположении
 */
public class Vector {
    private final int x;
    private final int y;

    /**
     * Публичный конструктор
     *
     * @param x координата X
     * @param y координата Y
     */
    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод  сложения двух объектов
     *
     * @param a первое слагаемой
     * @param b второе слакаемой
     * @return сумма
     */
    public static Vector add(Vector a, Vector b) {
        final var errorMessage = "Аргумент не может равняться null";
        return new Vector(Optional.ofNullable(a).orElseThrow(() -> new IllegalArgumentException(errorMessage)).getX() + Optional.ofNullable(b).orElseThrow(() -> new IllegalArgumentException(errorMessage)).getX(),
                a.getY() + b.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var vector = (Vector) o;

        if (x != vector.x) return false;
        return y == vector.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

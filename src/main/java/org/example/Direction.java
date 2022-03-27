package org.example;

public class Direction {
    public static final int DIRECTION_NUMBER = 360;
    private final int angle;
    private final int angularVelocity;

    public Direction(int angle, int angularVelocity) {
        if (angle >= 0 && angle < 360) {
            this.angle = angle;
            this.angularVelocity = angularVelocity;
        } else {
            throw new IllegalArgumentException(String.format("Угол должен быть от 0 до %s", DIRECTION_NUMBER - 1));
        }
    }

    public int getAngle() {
        return angle;
    }

    public int getAngularVelocity() {
        return angularVelocity;
    }

    public static Direction next(int angle, int angularVelocity) {
        return new Direction(calculateAngle(angle, angularVelocity), angularVelocity);
    }

    public Direction next() {
        return Direction.next(this.getAngle(), this.getAngularVelocity());
    }

    private static int calculateAngle(int angle, int angularVelocity) {
        final int i = (angle + angularVelocity) % DIRECTION_NUMBER;
        return i >= 0 ? i : DIRECTION_NUMBER + i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var direction = (Direction) o;

        if (angle != direction.angle) return false;
        return angularVelocity == direction.angularVelocity;
    }

    @Override
    public int hashCode() {
        int result = angle;
        result = 31 * result + angularVelocity;
        return result;
    }
}

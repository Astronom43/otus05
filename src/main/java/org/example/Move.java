package org.example;

public class Move {
    private final Movable movable;

    public Move(Movable movable) {
        this.movable = movable;
    }

    public void execute() {
        movable.setPosition(Vector.add(movable.getPosition(),movable.getVelocity()));
    }
}

package org.example;

public class Rotate {
    private final Rotable rotable;

    public Rotate(Rotable rotable) {
        this.rotable = rotable;
    }

    public void execute() {
        rotable.setDirection(rotable.getDirection().next());
    }
}

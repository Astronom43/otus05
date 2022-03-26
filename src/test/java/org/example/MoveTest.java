package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;


class MoveTest {

    Movable movable = Mockito.mock(Movable.class);

    @BeforeEach
    void init() {
        Mockito.when(movable.getPosition()).thenReturn(new Vector(12, 5));
        Mockito.when(movable.getVelocity()).thenReturn(new Vector(-7, 3));
    }

    @Test
    void testValidMove() {
        final Move move = new Move(movable);
        move.execute();
        Mockito.verify(movable, Mockito.times(1)).setPosition(new Vector(5, 8));
    }

    @Test
    void testNullPosition() {
        Mockito.when(movable.getPosition()).thenReturn(null);
        final Move move = new Move(movable);
        Assertions.assertThrows(IllegalArgumentException.class, move::execute, "Аргумент не может равняться null");
    }

    @Test
    void testNullVelocity() {
        Mockito.when(movable.getVelocity()).thenReturn(null);
        final Move move = new Move(movable);
        Assertions.assertThrows(IllegalArgumentException.class, move::execute, "Аргумент не может равняться null");
    }

}
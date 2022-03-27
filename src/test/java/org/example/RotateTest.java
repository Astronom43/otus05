package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

import static org.example.Direction.DIRECTION_NUMBER;

class RotateTest {

    Rotable rotable = Mockito.mock(Rotable.class);

    @ParameterizedTest
    @ArgumentsSource(CoefficientProvider.class)
    void testValidRotate(int initAngle, int angleVelocity, int rezAngle) {
        Mockito.when(rotable.getDirection()).thenReturn(new Direction(initAngle, angleVelocity));
        final Rotate rotate = new Rotate(rotable);
        rotate.execute();
        Mockito.verify(rotable, Mockito.times(1)).setDirection(new Direction(rezAngle, angleVelocity));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 360})
    void testNotValidInitDirection(int initAngle) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Direction(initAngle, 0), String.format("Угол должен быть от 0 до %s", DIRECTION_NUMBER - 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 359, 180})
    void testValidInitDirection(int initAngle) {
        Assertions.assertDoesNotThrow(() -> new Direction(initAngle, 0));
    }

    private static class CoefficientProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(0, 0, 0),
                    Arguments.of(359, 0, 359),
                    Arguments.of(359, 1, 0),
                    Arguments.of(180, 180, 0),
                    Arguments.of(0, -1, 359),
                    Arguments.of(10, -10, 0),
                    Arguments.of(10, -20, 350)
            );
        }
    }
}

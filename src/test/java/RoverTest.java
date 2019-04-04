import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test
    void roverHasPosition() {
        Rover rover = new Rover();
        assertThat(rover.position()).isEqualTo(Position.of(0,0));
    }

    private class Rover{
        public Position position() {
            return Position.of(0, 0);
        }
    }

    private static class Position {
        private final int x;
        private final int y;

        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Position of(int x, int y) {
            return new Position(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

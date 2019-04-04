import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test
    void hasPositionAndDirection() {
        Rover rover = new Rover();

        assertThat(rover.position()).isEqualTo(Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("N");
    }

    @Test
    void drivesForward() {
        Rover rover = new Rover();
        rover.move("f");

        assertThat(rover.position()).isEqualTo(Position.of(0, 1));
    }

    @Test
    void drivesBackwards() {
        Rover rover = new Rover();
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Position.of(0, -1));
    }

    private class Rover {

        private Position position;

        public Rover() {
            this.position = Position.of(0, 0);
        }

        public Position position() {
            return position;
        }


        public String direction() {
            return "N";
        }

        public void move(String direction) {
            if("f".equals(direction)) {
                position = Position.of(0, 1);
            } else {
                position = Position.of(0, -1);
            }
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

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
    void drivesForwardThreeTimes() {
        Rover rover = new Rover();
        rover.move("f");
        rover.move("f");
        rover.move("f");

        assertThat(rover.position()).isEqualTo(Position.of(0, 3));
    }

    @Test
    void drivesBackwards() {
        Rover rover = new Rover();
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Position.of(0, -1));
    }

    @Test
    void drivesForwardThenBackward() {
        Rover rover = new Rover();
        rover.move("f");
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Position.of(0, 0));
    }

    @Test
    void turnsLeft() {
        Rover rover = new Rover();
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("W");
    }

    @Test
    void turnsLeftTwice() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("S");
    }

    @Test
    void turnsLeftThreeTimes() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("E");
    }

    @Test
    void turnsLeftFourTimes() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("N");
    }

    private class Rover {

        private Position position;
        private String direction;

        public Rover() {
            this.position = Position.of(0, 0);
            this.direction = "N";
        }

        public Position position() {
            return position;
        }


        public String direction() {
            return direction;
        }

        public void move(String move) {
            if ("f".equals(move)) {
                position = Position.of(0, position.y + 1);
            } else {
                position = Position.of(0, position.y - 1);
            }
        }

        public void turn(String turn) {
            if ("N".equals(direction)) {
                direction = "W";
            } else if ("W".equals(direction)) {
                direction = "S";
            } else if ("S".equals(direction)) {
                direction = "E";
            } else {
                direction = "N";
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

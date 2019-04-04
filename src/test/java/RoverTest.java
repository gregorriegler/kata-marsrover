import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test
    void hasPositionAndDirection() {
        Rover rover = new Rover();

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("N");
    }

    @Test
    void drivesForward() {
        Rover rover = new Rover();
        rover.move("f");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 1));
    }

    @Test
    void drivesForwardThreeTimes() {
        Rover rover = new Rover();
        rover.move("f");
        rover.move("f");
        rover.move("f");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 3));
    }

    @Test
    void drivesBackwards() {
        Rover rover = new Rover();
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, -1));
    }

    @Test
    void drivesForwardThenBackward() {
        Rover rover = new Rover();
        rover.move("f");
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
    }

    @Test
    void turnsLeft() {
        Rover rover = new Rover();
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("W");
    }

    @Test
    void turnsLeftTwice() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("S");
    }

    @Test
    void turnsLeftThreeTimes() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("E");
    }

    @Test
    void turnsLeftFourTimes() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("N");
    }

    @Test
    void turnsRight() {
        Rover rover = new Rover();
        rover.turn("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("E");
    }

    @Test
    void turnsRightTwice() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.turn("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo("S");
    }

}

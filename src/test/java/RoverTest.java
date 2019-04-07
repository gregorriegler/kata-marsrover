import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoverTest {

    @Test
    void hasPositionAndDirection() {
        Rover rover = new Rover();

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
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
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnsLeftTwice() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnsLeftThreeTimes() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnsLeftFourTimes() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");
        rover.turn("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void turnsRight() {
        Rover rover = new Rover();
        rover.turn("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnsRightTwice() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.turn("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnsRightThreeTimes() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.turn("r");
        rover.turn("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnsRightFourTimes() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.turn("r");
        rover.turn("r");
        rover.turn("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void turnLeftThenForward() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.move("f");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(-1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnLeftThenBackward() {
        Rover rover = new Rover();
        rover.turn("l");
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnRightThenForward() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.move("f");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(+1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnRightThenBackward() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(-1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnRightTwoTimesThenForward() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.turn("r");
        rover.move("f");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, -1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnRightTwoTimesThenBackward() {
        Rover rover = new Rover();
        rover.turn("r");
        rover.turn("r");
        rover.move("b");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, +1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

}

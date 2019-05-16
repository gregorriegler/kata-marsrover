import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoverTest {

    @Test
    void hasPositionAndDirection() {
        Rover rover = new Rover();

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void uknownCommand() {
        Rover rover = new Rover();

        assertThatThrownBy(() -> rover.go("x")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void drivesForward() {
        Rover rover = new Rover();
        rover.go("f");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 1));
    }

    @Test
    void drivesForwardThreeTimes() {
        Rover rover = new Rover();
        rover.go("fff");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 3));
    }

    @Test
    void drivesBackwards() {
        Rover rover = new Rover();
        rover.go("b");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, -1));
    }

    @Test
    void drivesForwardThenBackward() {
        Rover rover = new Rover();
        rover.go("fb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
    }

    @Test
    void turnsLeft() {
        Rover rover = new Rover();
        rover.go("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnsLeftTwice() {
        Rover rover = new Rover();
        rover.go("ll");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnsLeftThreeTimes() {
        Rover rover = new Rover();
        rover.go("lll");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnsLeftFourTimes() {
        Rover rover = new Rover();
        rover.go("llll");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void turnsRight() {
        Rover rover = new Rover();
        rover.go("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnsRightTwice() {
        Rover rover = new Rover();
        rover.go("rr");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnsRightThreeTimes() {
        Rover rover = new Rover();
        rover.go("rrr");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnsRightFourTimes() {
        Rover rover = new Rover();
        rover.go("rrrr");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void turnLeftThenForward() {
        Rover rover = new Rover();
        rover.go("lf");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(-1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnLeftThenBackward() {
        Rover rover = new Rover();
        rover.go("lb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnRightThenForward() {
        Rover rover = new Rover();
        rover.go("rf");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(+1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnRightThenBackward() {
        Rover rover = new Rover();
        rover.go("rb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(-1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnRightTwoTimesThenForward() {
        Rover rover = new Rover();
        rover.go("rrf");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, -1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnRightTwoTimesThenBackward() {
        Rover rover = new Rover();
        rover.go("rrb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, +1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void moveAcrossTopEdgeOfWorld() {
        Rover rover = new Rover(new Rover.Position.World(2));
        rover.go("fff");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, -1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void moveAcrossBottomEdgeOfWorld() {
        Rover rover = new Rover(new Rover.Position.World(2));
        rover.go("llfff");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void moveAcrossLeftEdgeOfWorldBackwards() {
        Rover rover = new Rover(new Rover.Position.World(2));
        rover.go("rbbbb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }
}

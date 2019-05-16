import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoverTest {

    private Rover rover;
    private Rover roverOnEdge;

    @BeforeEach
    void setUp() {
        rover = new Rover();
        roverOnEdge = new Rover(new Rover.Position.World(2));
    }

    @Test
    void hasPositionAndDirection() {
        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void uknownCommand() {
        assertThatThrownBy(() -> rover.go("x")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void drivesForward() {
        rover.go("f");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 1));
    }

    @Test
    void drivesForwardThreeTimes() {
        rover.go("fff");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 3));
    }

    @Test
    void drivesBackwards() {
        rover.go("b");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, -1));
    }

    @Test
    void drivesForwardThenBackward() {
        rover.go("fb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
    }

    @Test
    void turnsLeft() {
        rover.go("l");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnsLeftTwice() {
        rover.go("ll");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnsLeftThreeTimes() {
        rover.go("lll");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnsLeftFourTimes() {
        rover.go("llll");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void turnsRight() {
        rover.go("r");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnsRightTwice() {
        rover.go("rr");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnsRightThreeTimes() {
        rover.go("rrr");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnsRightFourTimes() {
        rover.go("rrrr");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void turnLeftThenForward() {
        rover.go("lf");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(-1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnLeftThenBackward() {
        rover.go("lb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.W);
    }

    @Test
    void turnRightThenForward() {
        rover.go("rf");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(+1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnRightThenBackward() {
        rover.go("rb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(-1, 0));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.E);
    }

    @Test
    void turnRightTwoTimesThenForward() {
        rover.go("rrf");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, -1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void turnRightTwoTimesThenBackward() {
        rover.go("rrb");

        assertThat(rover.position()).isEqualTo(Rover.Position.of(0, +1));
        assertThat(rover.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void moveAcrossTopEdgeOfWorld() {
        roverOnEdge.go("fff");

        assertThat(roverOnEdge.position()).isEqualTo(Rover.Position.of(0, -1));
        assertThat(roverOnEdge.direction()).isEqualTo(Rover.Direction.N);
    }

    @Test
    void moveAcrossBottomEdgeOfWorld() {
        roverOnEdge.go("llfff");

        assertThat(roverOnEdge.position()).isEqualTo(Rover.Position.of(0, 1));
        assertThat(roverOnEdge.direction()).isEqualTo(Rover.Direction.S);
    }

    @Test
    void moveAcrossLeftEdgeOfWorldBackwards() {
        roverOnEdge.go("rbbbb");

        assertThat(roverOnEdge.position()).isEqualTo(Rover.Position.of(0, 0));
        assertThat(roverOnEdge.direction()).isEqualTo(Rover.Direction.E);
    }
}

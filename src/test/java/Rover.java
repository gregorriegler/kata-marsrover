import java.util.Objects;

public class Rover {

    public static final String MOVE_F = "f";
    public static final String TURN_L = "l";
    public static final String TURN_R = "r";

    private Position position;
    private Direction direction;

    public Rover() {
        this.position = Position.of(0, 0);
        this.direction = Direction.N;
    }

    public Position position() {
        return position;
    }


    public Direction direction() {
        return direction;
    }

    public void move(String move) {
        if (MOVE_F.equals(move)) {
            position = position.forward();
        } else {
            position = position.backward();
        }
    }

    public void turn(String turn) {
        if (Direction.N.equals(direction)) {
            if (TURN_R.equals(turn)) {
                direction = Direction.E;
            } else if (TURN_L.equals(turn)) {
                direction = Direction.W;
            }
        } else if (Direction.W.equals(direction)) {
            if (TURN_R.equals(turn)) {
                direction = Direction.N;
            } else if (TURN_L.equals(turn)) {
                direction = Direction.S;
            }
        } else if (Direction.S.equals(direction)) {
            if (TURN_R.equals(turn)) {
                direction = Direction.W;
            } else if (TURN_L.equals(turn)) {
                direction = Direction.E;
            }
        } else {
            if (TURN_R.equals(turn)) {
                direction = Direction.S;
            } else if (TURN_L.equals(turn)) {
                direction = Direction.N;
            }
        }
    }

    public static class Position {
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

        public Position forward() {
            return of(0, y + 1);
        }

        public Position backward() {
            return of(0, y - 1);
        }
    }

    public enum Direction {
        N, W, S, E;


        Direction() {
        }
    }
}

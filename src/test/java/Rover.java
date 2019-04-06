import java.util.Objects;

public class Rover {

    public static final String MOVE_F = "f";

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
        this.direction = direction.turn(turn);
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

        static {
            N.rightOf = E;
            N.leftOf = W;
            W.rightOf = N;
            W.leftOf = S;
            S.rightOf = W;
            S.leftOf = E;
            E.rightOf = S;
            E.leftOf = N;
        }

        private Direction rightOf;
        private Direction leftOf;

        public static final String TURN_R = "r";

        private Direction turn(String turn) {
            if (TURN_R.equals(turn)) {
                return this.rightOf;
            } else {
                return this.leftOf;
            }
        }

    }
}

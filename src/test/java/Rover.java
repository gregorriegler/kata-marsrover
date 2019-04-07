import java.util.Arrays;
import java.util.Objects;

public class Rover {

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
        this.position = Move.of(move).move(this.position, this.direction);
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

        public Position addToX(int newX) {
            return of(x + newX, y);
        }

        public Position addToY(int newY) {
            return of(x, y + newY);
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

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public enum Direction {
        N(1), W(-1), S(-1), E(+1);

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

        private final int vector;
        private Direction rightOf;
        private Direction leftOf;

        public static final String TURN_R = "r";

        Direction(int vector) {
            this.vector = vector;
        }

        private Direction turn(String turn) {
            if (TURN_R.equals(turn)) {
                return this.rightOf;
            } else {
                return this.leftOf;
            }
        }

    }

    public enum Move {
        FORWARD("f", 1),
        BACKWARD("b", -1);

        private final String asString;
        private final int vector;

        Move(String asString, int vector) {
            this.asString = asString;
            this.vector = vector;
        }

        public static Move of(String value) {
            Move move = Arrays.stream(Move.values())
                .filter(m -> m.asString.equals(value))
                .findFirst()
                .orElse(FORWARD);
            return move;
        }

        private Position move(Position position, Direction direction) {
            int vector = this.vector * direction.vector;
            if (Direction.W.equals(direction) || Direction.E.equals(direction)) {
                return position.addToX(vector);
            } else {
                return position.addToY(vector);
            }
        }

    }
}

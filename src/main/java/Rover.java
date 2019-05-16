import java.util.Arrays;
import java.util.Objects;

public class Rover {

    private Position position;
    private Direction direction;

    public Rover() {
        this(Position.of(0, 0), Direction.N);
    }

    public Rover(Position.World world) {
        this(Position.of(world, 0, 0), Direction.N);
    }

    public Rover(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position position() {
        return position;
    }

    public Direction direction() {
        return direction;
    }

    public void go(String commands) {
        for (char command : commands.toCharArray()) {
            if (Move.is(command)) {
                move(command);
            } else if (isTurn(command)) {
                turn(command);
            } else {
                throw new IllegalArgumentException("Unknown command.");
            }
        }
    }

    private boolean isTurn(char command) {
        return "lr".indexOf(command) >= 0;
    }

    private void move(Character move) {
        this.position = Move.of(move).move(this.position, this.direction);
    }

    private void turn(Character turn) {
        this.direction = direction.turn(turn);
    }

    public static class Position {

        private final World world;
        private final int x;
        private final int y;

        private Position(World world, int x, int y) {
            this.world = world;
            this.x = x;
            this.y = y;
        }

        public static Position of(int x, int y) {
            return new Position(new World(10), x, y);
        }

        public static Position of(World world, int x, int y) {
            return new Position(world, x, y);
        }

        public Position add(int x, int y) {
            return of(
                this.world,
                world.add(this.x, x),
                world.add(this.y, y)
            );
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

        public static class World {
            private final int radius;

            public World(int radius) {
                this.radius = radius;
            }

            public int add(int pos, int vector) {
                int result = pos + vector;
                if (result > radius) {
                    return radius - result;
                } else if (result < invertedRadius()) {
                    return invertedRadius() - result;
                } else {
                    return result;
                }
            }

            private int invertedRadius() {
                return radius * -1;
            }
        }
    }

    public enum Direction {
        N(0, 1),
        W(-1, 0),
        S(0, -1),
        E(1, 0);

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

        private final int vectorX;
        private final int vectorY;
        private Direction rightOf;
        private Direction leftOf;

        public static final Character TURN_R = 'r';

        Direction(int vectorX, int vectorY) {
            this.vectorX = vectorX;
            this.vectorY = vectorY;
        }

        private Direction turn(Character turn) {
            if (TURN_R.equals(turn)) {
                return this.rightOf;
            } else {
                return this.leftOf;
            }
        }
    }

    public enum Move {
        FORWARD('f', 1),
        BACKWARD('b', -1);

        private final Character asCharacter;
        private final int vector;

        Move(Character asCharacter, int vector) {
            this.asCharacter = asCharacter;
            this.vector = vector;
        }

        public static Move of(Character value) {
            Move move = Arrays.stream(Move.values())
                .filter(m -> m.asCharacter.equals(value))
                .findFirst()
                .orElse(FORWARD);
            return move;
        }

        public static boolean is(char command) {
            return Arrays.stream(Move.values()).anyMatch(m -> m.asCharacter.equals(command));
        }

        private Position move(Position position, Direction direction) {
            return position.add(
                this.vector * direction.vectorX,
                this.vector * direction.vectorY
            );
        }
    }
}

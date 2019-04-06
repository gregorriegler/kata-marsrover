import java.util.Objects;

public class Rover {

    public static final String N = "N";
    public static final String W = "W";
    public static final String S = "S";
    public static final String E = "E";
    public static final String MOVE_F = "f";
    public static final String TURN_L = "l";
    public static final String TURN_R = "r";

    private Position position;
    private String direction;

    public Rover() {
        this.position = Position.of(0, 0);
        this.direction = N;
    }

    public Position position() {
        return position;
    }


    public String direction() {
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
        if (N.equals(direction)) {
            if (TURN_R.equals(turn)) {
                direction = E;
            } else if (TURN_L.equals(turn)) {
                direction = W;
            }
        } else if (W.equals(direction)) {
            if (TURN_R.equals(turn)) {
                direction = N;
            } else if (TURN_L.equals(turn)) {
                direction = S;
            }
        } else if (S.equals(direction)) {
            if (TURN_R.equals(turn)) {
                direction = W;
            } else if (TURN_L.equals(turn)) {
                direction = E;
            }
        } else {
            if (TURN_R.equals(turn)) {
                direction = S;
            } else if (TURN_L.equals(turn)) {
                direction = N;
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
}

public class World {
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

public class Apple {
    private int apple_x, apple_y;

    public void spawnAppleCoor() {
        int r = (int) (Math.random() * Math.sqrt(SnakeData.ALL_TILES) - 1);
        apple_x = (r * Board.TILE_SIZE);

        r = (int) (Math.random() * Math.sqrt(SnakeData.ALL_TILES) - 1);
        apple_y = (r * Board.TILE_SIZE);
    }
    public int getApple_x() {
        return apple_x;
    }

    public void setApple_x(int apple_x) {
        this.apple_x = apple_x;
    }

    public int getApple_y() {
        return apple_y;
    }

    public void setApple_y(int apple_y) {
        this.apple_y = apple_y;
    }
}

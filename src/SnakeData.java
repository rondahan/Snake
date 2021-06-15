public class SnakeData {
    public static final int ALL_TILES = 900; // Total numer of tiles
    private int[] xCoor = new int[ALL_TILES];
    private int[] yCoor = new int[ALL_TILES];
    private int snakeSize = 3;
    public void incSnakeSize() {
        snakeSize++;
    }

    public int getycooritem(int position){
        return yCoor[position];
    }

    public int getxcooritem(int position){
        return xCoor[position];
    }
    public void setycooritem(int position , int value) {
        yCoor[position] = value;

    }

    public void setxcooritem(int position , int value) {
        xCoor[position] = value;

    }

    public int getSnakeSize() {
        return snakeSize;
    }

    public void setSnakeSize(int snakeSize) {
        this.snakeSize = snakeSize;
    }



    public int getALL_TILES() {
        return ALL_TILES;
    }

    public int[] getxCoor() {
        return xCoor;
    }

    public void setxCoor(int[] xCoor) {
        this.xCoor = xCoor;
    }

    public int[] getyCoor() {
        return yCoor;
    }

    public void setyCoor(int[] yCoor) {
        this.yCoor = yCoor;
    }


}

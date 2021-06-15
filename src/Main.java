import javax.swing.*;


class Snake extends JFrame {

    private final int BOARD_WIDTH = 20 * 30;
    private final int BOARD_HEIGHT = 20 * 30;
    private final int TILE_SIZE = 20;
    private final int DELAY = 100;


    public Snake() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(BOARD_WIDTH, BOARD_HEIGHT);
        setResizable(false);
        setLocation(50, 50);
        setTitle("Snake ... Try to Beat 100!!");

        Board b = new Board(this);

        addKeyListener(b);
        add(b);
        setVisible(true);

        Timer t = new Timer(DELAY, b);
        t.start();
    }

    public static void main(String[] args) {
        Snake s = new Snake();
    }
}

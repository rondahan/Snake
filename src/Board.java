import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Board extends JPanel implements KeyListener, ActionListener {
    private final int BOARD_WIDTH = 20 * 30; // Tilesize * number of columns
    private final int BOARD_HEIGHT = 20 * 30;
    public static final int TILE_SIZE = 20;
    private SnakeData snakeData;
    private final int DELAY = 100;
    private boolean inGame = true;
    int pressedKey = KeyEvent.VK_DOWN;
    int oldPressedKey;
    Snake snake;
    Apple apple;

    public Board(Snake snake) {
        snakeData = new SnakeData();
        setBackground(Color.black);
        this.snake = snake;
        this.apple = new Apple();


        for (int i = 0; i < snakeData.getSnakeSize(); i++) {
            snakeData.setycooritem(i , 140 - (i * 30));
            snakeData.setxcooritem(i , 140);
        }

        apple.spawnAppleCoor();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (inGame) {


            g.setColor(Color.red);
            g.fillRect(apple.getApple_x(),apple.getApple_y(), TILE_SIZE, TILE_SIZE);


            for (int i = 0; i <snakeData.getSnakeSize(); i++) {

                if (i == 0) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(Color.green);
                }

                g.fillRect(snakeData.getxcooritem(i), snakeData.getycooritem(i), TILE_SIZE, TILE_SIZE);
            }

 
            g.setFont(new Font("Sans serif", Font.BOLD, 20));
            g.drawString(getScore(), 550, 30);

        } else {
            gameOver(g);
        }
    }

    public void actionPerformed(ActionEvent e) {

        checkTile();
        moveSnakeCoor();
        repaint();

    }

    public void keyPressed(KeyEvent e) {
        oldPressedKey = pressedKey;
        pressedKey = e.getKeyCode();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    private void checkTile() {
        /* Check if outside of wall. */
        if (snakeData.getxcooritem(0) > BOARD_WIDTH ||snakeData.getxcooritem(0) < 0 ||snakeData.getycooritem(0) > BOARD_HEIGHT || snakeData.getycooritem(0) < 0) {
            inGame = false;
        }


        for (int i = 1; i < snakeData.getxCoor().length; i++) {
            if (snakeData.getxcooritem(0) ==snakeData.getxcooritem(i) && snakeData.getycooritem(0) == snakeData.getycooritem(i)) {
                inGame = false;
            }
        }


        if ((snakeData.getxcooritem(0) ==apple.getApple_x()) && (snakeData.getycooritem(0) == apple.getApple_y())) {
            snakeData.incSnakeSize();
            apple.spawnAppleCoor();
        }
    }


    private void gameOver(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Sans serif", Font.BOLD, 20));
        g.drawString(("Nice You ate  " + (getScore()) + " apples"),
                BOARD_WIDTH / 4, BOARD_HEIGHT / 2);
        g.drawString("Press space to restart",
                BOARD_WIDTH / 4 + 20, BOARD_HEIGHT / 2 + 30);


        if (pressedKey == KeyEvent.VK_SPACE) {
            inGame = true;
            pressedKey = KeyEvent.VK_DOWN;
            setVisible(false);
            snake.dispose();
            Snake s = new Snake();
        }
    }

    private void moveSnakeCoor() {


        for (int i = snakeData.getSnakeSize(); i > 0; i--) {

           snakeData.setxcooritem(i , snakeData.getxcooritem(i-1));
           snakeData.setycooritem(i , snakeData.getycooritem(i-1));
        }


        switch (pressedKey) {
            case KeyEvent.VK_DOWN:
                snakeData.setycooritem(0 ,snakeData.getycooritem(0)+TILE_SIZE);
                break;
            case KeyEvent.VK_UP:
                snakeData.setycooritem(0 ,snakeData.getycooritem(0)-TILE_SIZE);
                break;
            case KeyEvent.VK_LEFT:
                snakeData.setxcooritem(0 ,snakeData.getxcooritem(0)-TILE_SIZE);
                break;
            case KeyEvent.VK_RIGHT:
                snakeData.setxcooritem(0 ,snakeData.getxcooritem(0)+TILE_SIZE);
                break;
        }
    }

    private String getScore() {
        return "" + (snakeData.getSnakeSize() - 3);
    }
}

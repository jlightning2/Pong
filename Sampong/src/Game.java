import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game {

  // prims
  private final int W, H; /* in pixels */

  // objects
  private Ball ball;
  private Paddle paddle;
  private List<Brick> bricks = new ArrayList<Brick>();

  // graphical objects
  protected JFrame frame;
  protected JPanel panel;

  // Constructor
  Game(int width, int height, int numBricks) {
    this.W = width;
    this.H = height;

    // x y w h
    int bx = (int) (width / 2);
    int by = (int) (height / 2);
    int bw = (int) (width * 0.05);
    int bh = (int) (height * 0.05);
    ball = new Ball(bx, by, bw, bh);

    // x y w h
    int pw = (int) (width / 10);
    int px = (int) (width / 2 - (pw / 2));
    int py = (int) height - (int) (height * .1);
    paddle = new Paddle(px, py, pw, pw / 5);

    // Populate bricks; width = 10% screen width, height = ???
    int whiteSpace = (int) (width / 10);
    bw = (int) (width - whiteSpace) / numBricks;
    bh = (int) (height * 0.05);
    by = bh;
    int marginwidth = (int) (whiteSpace / (numBricks + 1));
    bx = marginwidth;
    for (int i = 0; i < numBricks; i++) {
      this.bricks.add(new Brick(bx, by, bw, bh));
      bx += bw + marginwidth;
    }
  }

  private void start() {
    frame = new JFrame("Pong");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    panel = new JPanel() {
      public Dimension getPreferredSize() {

        return new Dimension(W, H);
      }

      public void paint(Graphics g) {
        for (Brick b : bricks) {
          b.paint(g);
        }

        ball.paint(g);
        paddle.paint(g);
      }
    };
    frame.setContentPane(panel);
    frame.pack();
    frame.setVisible(true);

    while (true) {
      try {
        tick();
        frame.repaint();
        Thread.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  public void tick() {
    ball.tick();
  }


  public static void main(String[] args) {
    new Game(600,600, 10).start();
  }
}

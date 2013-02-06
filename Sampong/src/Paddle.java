import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Entity {

  public Paddle(int x, int y, int w, int h) {
    super(x, y, w, h);
  }

  public void paint(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillRect(x, y, WIDTH, HEIGHT);

    g.setColor(Color.BLACK);
    g.drawRect(x, y, WIDTH, HEIGHT);
  }

}

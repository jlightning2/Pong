import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Entity {

  int r;
  int dx = 0;
  int dy = 1;

  public Ball(int x, int y, int w, int h) {
    super(x, y, w, h);
    // dont' use w, h
    r = w;
  }

  public void tick() {
    x += dx;
    y += dy;
  }

  public int getRadius() {
    return r;
  }

  public void paint(Graphics g) {
    // filling
    g.setColor(Color.yellow);
    g.fillOval(x, y, r, r);

    // outline
    g.setColor(Color.BLACK);
    g.drawOval(x, y, r, r);
  }

}

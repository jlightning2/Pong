
public class Entity {
  int x, y;
  final int WIDTH, HEIGHT;

  public Entity(int x, int y, int w, int h) {
    this.x = x;
    this.y = y;
    this.WIDTH = w;
    this.HEIGHT = h;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return WIDTH;
  }

  public int getHeight() {
    return HEIGHT;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }
}

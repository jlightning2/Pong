import java.util.ArrayList;
import java.util.List;


public class Game {
	
  // prims
  private final int WIDTH, HEIGHT; /* in pixels */

  // objects
  private Ball ball;
  private Paddle paddle;
	private List<Brick> bricks = new ArrayList<Brick>();	

  // Constructor
	Game(int width, int height, int numBricks) {
	  this.WIDTH = width;
	  this.HEIGHT = height;

    // x y w h
    int bx = (int) (width / 2);
    int by = (int) (height / 2);
    int bw = (int) (width * 0.2);
    int bh = (int) (height * 0.2);
    ball = new Ball(bx, by, bw, bh);

    // x y w h
    int pw = (int) (width / 10);
    int px = (int) (pw / 2 - pw);
    int py = (int) (height * 0.95);
    paddle = new Paddle(px, py, pw, pw / 2);
	  
    // Populate bricks; width = 10% screen width, height = ???
    int whitespace = (int) (width / 10);
    bw = (int) (width - whitespace) / numBricks;
    bh = (int) (height * 0.05);
    by = bh;
    int marginwidth = (int) (whitespace / (numBricks + 1));
    bx = marginwidth;
    for (int i = 0; i < numBricks; i++) {
      this.bricks.add(new Brick(bx, by, bw, bh));
      bx += bw + marginwidth;
	  }
	}
	

	public static void main(String[] args) {
		
		Game game = new Game(600, 400, 10);
		game.start();
	}

  private void start() {

    
  }	
}

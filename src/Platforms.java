import java.awt.Graphics;
import java.util.Random;

public class Platforms extends GameObject  {

	public Platforms(int x, int y, int width, int height, double yVel, boolean isAlive) {
		super(x, y, width, height, yVel, isAlive);
		
	}
	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
	void update(double gravity) {
		y-=yVel;
		yVel+=gravity;
	}
}

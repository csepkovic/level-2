 import java.awt.Color;
import java.awt.Graphics;
//hery
public class Character extends GameObject {
	static int xSpeed;
	static int ySpeed;
	static boolean up = false;
	static boolean down = false;
	static boolean right = false;
	static boolean left = false;

	public Character(int x, int y, int width, int height, int xSpeed, int ySpeed, int health, boolean isAlive) {
		super(x, y, width, height, health, isAlive);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	void update() {
		super.update();
		if (health == 0) {
			isAlive = false;
		}
		if (up == true) {
			y-=ySpeed;
			down = false;
		} 
		if (down == true) {
			y+=ySpeed;
			up = false;
		} 
		if (right == true) {
			x+=xSpeed;
			left = false;
		} 
		if (left == true) {
			x-=xSpeed;
			right = false;
		} 
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(x, y, width, height, true);
	}
	
	void reset () {
		x = 325;
		y = 250;
	}
}

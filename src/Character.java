import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject {
	int xSpeed;
	int ySpeed;
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;

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
		} 
		if (down == true) {
			y+=ySpeed;
		} 
		if (right == true) {
			x+=xSpeed;
		} 
		if (left == true) {
			x-=xSpeed;
		} 
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(x, y, width, height, true);
	}
}

 import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Character extends GameObject {
	ArrayList <Integer> pastX = new ArrayList<>();
	ArrayList <Integer> pastY = new ArrayList<>();
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
		super.draw(g);
		g.setColor(Color.WHITE);
		g.fill3DRect(x, y, width, height, true);
		if (pastX.size()<4) {
		pastX.add(x);
		pastY.add(y);
		} else {
			pastX.remove(0);
			pastY.remove(0);
		}
		for (int i = 0; i < pastX.size(); i++) {
			g.setColor(new Color(255, 255, 255, 70));
			g.drawRect(pastX.get(i), pastY.get(i), width, height);
		}
	}
	
	void reset () {
		x = 325;
		y = 250;
	}
	
	public int getX() {
		return x;
		
	}
	public int getY() {
		return y;
		
	}
}

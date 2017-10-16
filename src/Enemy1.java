import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Enemy1 extends GameObject{
	int ySpeed;
	int xSpeed;

	public Enemy1(int x, int y, int width, int health, int height, boolean isAlive, int ySpeed, int xSpeed) {
		super(x, y, width, height, health, isAlive);
		this.ySpeed = ySpeed;
		this.xSpeed = xSpeed;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.drawRect(x, y, width, height);
	}
	int random;
	int random1;
	void update() {
		random = new Random().nextInt(3);
		random-=1;
		random1 = new Random().nextInt(3);
		random1-=1;
		if (GamePanel.character.x > x) {
			x+=xSpeed;
		} else if (GamePanel.character.x < x) {
			x-=xSpeed;
		}
		if (GamePanel.character.y > y) {
			y+=ySpeed;
		} else if (GamePanel.character.y < y) {
			y-=ySpeed;
		}
		x+=random;
		y+=random1;
	}

}

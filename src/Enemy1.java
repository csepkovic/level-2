import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Enemy1 extends GameObject{
	int ySpeed;
	int xSpeed;
	ArrayList <Integer> pastX = new ArrayList<>();
	ArrayList <Integer> pastY = new ArrayList<>();
	
	public Enemy1(int x, int y, int width, int health, int height, boolean isAlive, int ySpeed, int xSpeed) {
		super(x, y, width, height, health, isAlive);
		this.ySpeed = ySpeed;
		this.xSpeed = xSpeed;
	}
	
	void draw(Graphics g) {
		if (GamePanel.level.levelType==1) {
			g.setColor(new Color(255, 255, 255, 25));
		} else {
		g.setColor(Color.MAGENTA); 
		}
		g.drawRect(x, y, width, height);
		if (pastX.size()<50) {
			pastX.add(x);
			pastY.add(y);
			} else {
				pastX.remove(0);
				pastY.remove(0);
			}
			for (int i = 0; i < pastX.size(); i++) {
				if (GamePanel.level.levelType==1) {
					g.setColor(new Color(255, 255, 255, 55-i));
				} else {
					g.setColor(new Color(255, 0, 255, 50)); 
				}
				g.drawRect(pastX.get(i), pastY.get(i), width, height);
			}
		super.draw(g);
	}
	int random;
	int random1;
	int probability;
	void update() {
		super.update();
		probability = new Random().nextInt(5);
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
		if (probability == 1) {
			x+=3;
		} else if (probability == 2) {
			x-=3;
		} else if (probability == 3) {
			y+=3;
		} else if (probability == 4) {
			y-=3;
		}
	}

}

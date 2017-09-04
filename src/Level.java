import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Level extends GameObject  {
	int levelType;
	public Level(int x, int y, int width, int height, int health, boolean isAlive, int levelType) {
		super(x, y, width, height, health, isAlive);
		this.levelType = levelType;
	}
	void draw(Graphics g) {
		g.drawRect(x, y, width, height);
		if (levelType == 1) {
			int random1 = new Random().nextInt(155);
			random1+=100;
			int random2 = new Random().nextInt(155);
			random2+=100;
			int random3 = new Random().nextInt(155);
			random3+=100;
			Color color = new Color(random1, random2, random3);
			g.setColor(color);;
			g.fillRect(x, y, width, height);
		}
	}
	
	void update() {
		
	}
}

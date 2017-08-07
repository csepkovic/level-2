import java.awt.Graphics;
import java.util.Random;

public class Level extends GameObject  {
	int levelType;
	public Level(int x, int y, int width, int height, boolean isAlive, int levelType) {
		super(x, y, width, height, isAlive);
		this.levelType = levelType;
	}
	void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
	
	void update() {
		
	}
}

import java.awt.Color;
import java.awt.Graphics;

public class Character extends GameObject{
	int xSpeed;
	int ySpeed;
	public Character(int x, int y, int width, int height, int xSpeed, int ySpeed, boolean isAlive) {
		super(x, y, width, height, isAlive);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	void update(){
		super.update();
		x+=xSpeed;
		y+=ySpeed;
	}
	
	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fill3DRect(x, y, width, height, true);
	}
}

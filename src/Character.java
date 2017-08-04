import java.awt.Graphics;

public class Character extends GameObject{
	int speed;
	double gravity;
	double yVel;
	public Character(int x, int y, int width, int height, int speed, double yVel, boolean isAlive) {
		super(x, y, width, height, yVel, isAlive);
		this.speed = speed;
		this.yVel = yVel;
	}
	void update(double gravity){
		super.update(gravity);
		x+=speed;
		y+=yVel;
		yVel+=gravity;
	}
	void draw(Graphics g) {
		g.fill3DRect(x, y, width, height, true);
	}
}

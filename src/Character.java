import java.awt.Graphics;

public class Character extends GameObject{
	int speed;
	double gravity;
	double yVel;
	public Character(int x, int y, int width, int height, int speed, double gravity, double yVel) {
		super(x, y, width, height);
		this.speed = speed;
		this.gravity = gravity;
		this.yVel = yVel;
	}
	void update(){
		super.update();
		x+=speed;
		y+=yVel;
		yVel+=gravity;
		if (y >= 725){
			yVel=0;
		}
	}
	void draw(Graphics g) {
		g.fillRect(x, y, width, height);
	}
}

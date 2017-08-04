import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	double yVel;
	boolean isAlive;
	public GameObject(int x, int y, int width, int height, double yVel, boolean isAlive){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.yVel = yVel;
		this.isAlive = isAlive;
	}
	void update(double gravity2){
		
	}
	void draw(Graphics g){
		
	}
}

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int health;
	boolean isAlive;
	Rectangle collisionBox;
	public GameObject(int x, int y, int width, int height, int health, boolean isAlive){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
		this.isAlive = isAlive;
		collisionBox = new Rectangle(x, y, width, height);
	}
	void update(){
		
	}
	void draw(Graphics g){
		
	}
}

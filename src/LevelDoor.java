import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LevelDoor extends GameObject{
	int doorType;
	public LevelDoor(int x, int y, int width, int height, boolean isAlive, int doorType) {
		super(x, y, width, height, isAlive);
		this.doorType = doorType;
	}
	void draw(Graphics g){
		if (doorType == 1) {
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
	void update(){
		
	}
}

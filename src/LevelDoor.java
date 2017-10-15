import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class LevelDoor extends GameObject{
	public LevelDoor(int x, int y, int width, int height, int health, boolean isAlive) {
		super(x, y, width, height, health, isAlive);
	}
	int doorType = new Random().nextInt(100);
	int getDoorType (){
		return doorType;
	}
	void draw(Graphics g){
		if (doorType <= 10) {
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
		else if (doorType > 10 && doorType <= 30) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		} 
		else if (doorType > 30 && doorType <= 50) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
		} else if (doorType > 50 && doorType <= 70) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, width, height);
			//Put skull here
		} else if (doorType > 70 && doorType <= 90) {
			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);
		} else if (doorType > 90) {
			g.drawImage(GamePanel.pixelSpace, x, y, width, height, null);
		}
	}
	void update(){
		
	}
}

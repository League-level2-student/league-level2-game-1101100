import java.awt.Graphics;
import java.awt.Color;

public class Wizard extends GameObject{
	public Wizard(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void update() {
		super.update();
		
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

}

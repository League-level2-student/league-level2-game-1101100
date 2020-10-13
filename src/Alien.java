import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Alien extends GameObject{

boolean reverse = true;
Random numArrow = new Random();	
ArrayList<Integer> numberArrows = new ArrayList<Integer>();
final static int UP = 0;
final static int DOWN = 1;
final static int LEFT = 2;
final static int RIGHT = 3;
final int maxRandomNum = 4; 
public BufferedImage up;
public BufferedImage down;
public BufferedImage left;
public BufferedImage right;
public static BufferedImage ghost;
final static int arrowUnitsAboveGhost = 60;
int arrows = numArrow.nextInt(maxRandomNum)+1;
	public Alien(int x, int y, int width, int height, boolean reverse) {
		super(x, y, width, height);
		this.reverse = reverse;
			 try {
			 up = ImageIO.read(this.getClass().getResourceAsStream("up.png"));
	         down = ImageIO.read(this.getClass().getResourceAsStream("down.png"));
	         left = ImageIO.read(this.getClass().getResourceAsStream("left.png"));
	         right = ImageIO.read(this.getClass().getResourceAsStream("right.png"));
	         ghost = ImageIO.read(this.getClass().getResourceAsStream("ghost.png"));
			 } catch (IOException e) {
				 
				e.printStackTrace();
			 }
		
		for(int i = 1; i<=arrows; i++ ) {
			numberArrows.add(numArrow.nextInt(maxRandomNum));
		}
	}
	
	void update() {
		super.update();
		//TODO NEEDS TO SPAWN FROM BOTH X=0 & X = 500
		
		if (reverse) {
			x-=2; 
		}
		else {
			x+=2;
		}
	}
	void attacked(int arrowCheck) {
		if(numberArrows.contains(arrowCheck)) {
			int location = numberArrows.indexOf(arrowCheck);
			numberArrows.remove(location);
		}
	}

	void draw(Graphics g) {
		g.drawImage(ghost, x, y, width, height, null);
		for (int i = 0; i < numberArrows.size(); i++) {
			
			if(numberArrows.get(i) == UP) {
				g.drawImage(up, x - (i*arrowUnitsAboveGhost), y-arrowUnitsAboveGhost, width, height, null);
			}
			else if(numberArrows.get(i) == DOWN) {
				g.drawImage(down, x - (i*arrowUnitsAboveGhost), y-arrowUnitsAboveGhost, width, height, null);
			}
			else if(numberArrows.get(i) == LEFT) {
				g.drawImage(left, x - (i*arrowUnitsAboveGhost), y-arrowUnitsAboveGhost, width, height, null);
			}
			else if(numberArrows.get(i) == RIGHT) {
				g.drawImage(right, x - (i*arrowUnitsAboveGhost), y-arrowUnitsAboveGhost, width, height, null);
			}
			
		}
	}

}

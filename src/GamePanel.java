import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer frameDraw;
	Timer ghostSpawn;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font normalFont;
	
	public GamePanel() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	
	void updateMenuState() {  
		
	}
	void updateGameState() {  
		
	}
	void updateEndState()  {  
		
	}
	void drawMenuState(Graphics g) {  
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Halloween.width, Halloween.height);
	}
	void drawGameState(Graphics g) {  
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Halloween.width, Halloween.height);
		
		
	}
	void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, Halloween.width, Halloween.height);

	}

	
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}  
		if (e.getKeyCode()==KeyEvent.VK_UP) {
		    System.out.println("UP");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
		repaint();
	}

}

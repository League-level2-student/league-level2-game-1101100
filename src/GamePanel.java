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
	Wizard wizard = new Wizard(225, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(wizard);
	Timer alienSpawn;
	void startGame() {
		 //alienSpawn = new Timer(1000 , objectManager);
		// alienSpawn.start();
	}
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
		objectManager.draw(g);
		
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
		        alienSpawn.stop();
		      
		    } 
		    if (currentState == MENU){
		        currentState++;
		        wizard = new Wizard(250, 700, 50,50);
		    	objectManager = new ObjectManager(wizard);
		    }
		    if(currentState == GAME) {
		    	startGame();
		    }
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

import java.awt.Dimension;

import javax.swing.JFrame;

public class Halloween {
	static int width = 1000;
	static int height = 700;
	GamePanel gPanel = new GamePanel();
	
	JFrame frame = new JFrame();
	
	public static void main(String[] args) {
		Halloween game = new Halloween();
		
		game.setup();
	}
	
	void setup() {
		frame.add(gPanel);
		frame.addKeyListener(gPanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
	}
}

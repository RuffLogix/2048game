package main;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
	
	public GameWindow(GamePanel gamePanel) {

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(gamePanel);
		this.pack();
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

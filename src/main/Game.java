package main;

public class Game implements Runnable{
	
	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	
	public Game() {
		gamePanel = new  GamePanel();
		gameWindow = new GameWindow(gamePanel);
		
		gamePanel.requestFocus();
		startThread();
	}

	private void startThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}

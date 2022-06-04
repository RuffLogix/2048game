package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

import main.GamePanel;

public class KeyboardInputs implements KeyListener{

	private GamePanel gamePanel;
	public boolean tileChange=false;
	
	public KeyboardInputs(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		tileChange = false;
		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_W:
				gamePanel.updateTilesW();
				break;
			case KeyEvent.VK_A:
				gamePanel.updateTilesA();
				break;
			case KeyEvent.VK_S:
				gamePanel.updateTilesS();
				break;
			case KeyEvent.VK_D:
				gamePanel.updateTilesD();
				break;
			case KeyEvent.VK_R:
				gamePanel.resetTile();
				break;
			default:
				return;
		}
		
		if(tileChange == true) {
			gamePanel.randomlySpawn();
			gamePanel.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

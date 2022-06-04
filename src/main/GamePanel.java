package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;

public class GamePanel extends JPanel{

	private int tiles[][] = new int[4][4];
	private KeyboardInputs keyboardInputs;
	private Integer totalScore = 0;
	
	public GamePanel() {
		keyboardInputs = new KeyboardInputs(this);
		
		setPanelSize();
		initTiles();
		randomlySpawn();
		
		addKeyListener(keyboardInputs);
	}
	
	private void setPanelSize() {
		Dimension dim = new Dimension(400, 500);
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
	}
	
	private void initTiles() {
		for(int i=0 ; i<4 ; i++) { // set all tiles = 0;
			for(int j=0 ; j<4 ; j++) {
				tiles[i][j] = 0;
			}
		}
	}
	
	public void updateTilesA() {
		
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				int ii = i;
				boolean mergeDone = false;
				while(ii>=1) {
					if(tiles[ii-1][j]!=0 && tiles[ii-1][j]!=tiles[ii][j]) break;
					
					keyboardInputs.tileChange = true;
					if(tiles[ii-1][j]==0)
						tiles[ii-1][j] = tiles[ii][j];
					else if(mergeDone) {
						break;
					}else {
						mergeDone = true;
						totalScore += tiles[ii-1][j];
						tiles[ii-1][j] *= 2;
					}
					tiles[ii][j]=0;
					ii--;
				}
			}
		}
	}
	
	public void updateTilesW() {
		
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				int jj = j;
				boolean mergeDone = false;
				while(jj>=1) {
					if(tiles[i][jj-1]!=0 && tiles[i][jj-1]!=tiles[i][jj]) break;
					
					keyboardInputs.tileChange = true;
					if(tiles[i][jj-1]==0)
						tiles[i][jj-1] = tiles[i][jj];
					else if(mergeDone) {
						break;
					}else {
						mergeDone = true;
						totalScore += tiles[i][jj-1];
						tiles[i][jj-1] *= 2;
					}
					tiles[i][jj]=0;
					jj--;
				}
			}
		}
	}
	
	public void updateTilesD() {
		
		for(int i=3 ; i>=0 ; i--) {
			for(int j=0 ; j<4 ; j++) {
				int ii = i;
				boolean mergeDone = false;
				while(ii<=2) {
					if(tiles[ii+1][j]!=0 && tiles[ii+1][j]!=tiles[ii][j]) break;
					
					keyboardInputs.tileChange = true;
					if(tiles[ii+1][j]==0)
						tiles[ii+1][j] = tiles[ii][j];
					else if(mergeDone) {
						break;
					}else {
						mergeDone = true;
						totalScore += tiles[ii+1][j];
						tiles[ii+1][j] *= 2;
					}
					tiles[ii][j]=0;
					ii++;
				}
			}
		}
	}
	
	public void updateTilesS() {
		
		for(int i=0 ; i<4 ; i++) {
			for(int j=3 ; j>=0 ; j--) {
				int jj = j;
				boolean mergeDone = false;
				while(jj<=2) {
					if(tiles[i][jj+1]!=0 && tiles[i][jj+1]!=tiles[i][jj]) break;
					
					keyboardInputs.tileChange = true;
					if(tiles[i][jj+1]==0)
						tiles[i][jj+1] = tiles[i][jj];
					else if(mergeDone) {
						break;
					}else {
						mergeDone = true;
						totalScore += tiles[i][jj+1];
						tiles[i][jj+1] *= 2;
					}
					tiles[i][jj]=0;
					jj++;
				}
			}
		}
	}
	
	public void randomlySpawn() {
		int emptyTiles = 0;
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) { 
				if(tiles[i][j]==0)
					emptyTiles++;
			}
		}
		
		Random rand_x = new Random();
		Random rand_y = new Random();
		
		while(emptyTiles!=0) {
			int new_x = Math.abs(rand_x.nextInt()%4);
			int new_y = Math.abs(rand_y.nextInt()%4);
			
			if(tiles[new_x][new_y] == 0) {
				tiles[new_x][new_y] = 2;
				break;
			}
		}
	}
	
	public Color getTileColor(int val) {
		Color tileColor = null;
		
		switch(val) {
			case 2:
				tileColor = new Color(200, 255, 200);
				break;
			case 4:
				tileColor = new Color(150, 255, 150);
				break;
			case 8:
				tileColor = new Color(135, 255, 135);
				break;
			case 16:
				tileColor = new Color(120, 255, 120);
				break;
			case 32:
				tileColor = new Color(105, 255, 105);
				break;
			case 64:
				tileColor = new Color(90, 255, 90);
				break;
			case 128:
				tileColor = new Color(75, 255, 75);
				break;
			case 256:
				tileColor = new Color(60, 255, 60);
				break;
			case 512:
				tileColor = new Color(45, 255, 45);
				break;
			case 1024:
				tileColor = new Color(30, 255, 30);
				break;
			case 2048:
				tileColor = new Color(15, 255, 15);
				break;
			case 4096:
				tileColor = new Color(0, 255, 0);
				break;
		}
		
		return tileColor;
	}
	
	public void resetTile() {
		totalScore = 0;
		
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				tiles[i][j] = 0;
			}
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		System.out.println("=====");
		for(int i=0 ; i<4 ; i++) {
			for(int j=0 ; j<4 ; j++) {
				if(tiles[i][j]==0) {
					g.setColor(new Color(32, 32, 35));
					g.fillRect(i*100, j*100, 100, 100);
				}else {
					g.setColor(getTileColor(tiles[i][j]));
					g.fillRect(i*100, j*100, 100, 100);
					g.setColor(new Color(100, 100, 100));
					g.drawRect(i*100, j*100, 100, 100);
					
					Integer value = tiles[i][j]; 
					g.drawString(value.toString(), i*100+50, j*100+50);
				}
//				System.out.print(tiles[j][i]+ " ");
			}
//			System.out.println();
		}
		
		g.drawString(totalScore.toString(), 200, 450);
	}
	
}

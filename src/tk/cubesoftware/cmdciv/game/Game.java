package tk.cubesoftware.cmdciv.game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import tk.cubesoftware.cmdciv.render.InputAdapter;

public class Game extends InputAdapter {
	private boolean running;
	
	public Game() {
		running = true;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics2D g) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}

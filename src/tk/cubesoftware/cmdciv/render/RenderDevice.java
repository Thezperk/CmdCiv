package tk.cubesoftware.cmdciv.render;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import tk.cubesoftware.cmdciv.game.Game;

@SuppressWarnings("serial")
public class RenderDevice extends JPanel {
	private BufferedImage canvas;
	private Graphics2D buffer;
	private int width, height;
	private int fps = 1000/60;
	private Game game;
	
	public RenderDevice(int width, int height, Game game) {
		canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.width = width;
		this.height = height;
		this.game = game;
		buffer = canvas.createGraphics();
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setColor(Color.white);
		g2d.drawImage(canvas, 0, 0, getWidth(), getHeight(), null);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	public void startGameLoop() {
		while (game.isRunning()) {
			long initialTime = System.currentTimeMillis();
			
			buffer.setColor(Color.black);
			buffer.fillRect(0, 0, width, height);
			game.update();
			game.draw(buffer);
			repaint();
			
			long endTime = System.currentTimeMillis();
			long targetWait = (fps - 5) - (endTime - initialTime);
			
			try {
				Thread.sleep(targetWait >= 0? targetWait: 0);
				Thread.sleep(5);
			} catch (InterruptedException e) {
				System.out.println("Error with timer");
			}
			
		}
	}
}


package tk.cubesoftware.cmdciv.launch;

import javax.swing.JFrame;

import tk.cubesoftware.cmdciv.game.Game;
import tk.cubesoftware.cmdciv.render.RenderDevice;

public class Launcher {
	
	private static final String VERSION = "0.0.1";
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("CmdCiv - Version 0.0.1");
		Game game = new Game();
		RenderDevice render = new RenderDevice(800, 500, game);
		
		frame.addKeyListener(game);
		frame.addMouseListener(game);
		frame.addMouseMotionListener(game);
		
		frame.add(render);
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		render.startGameLoop();
	}
}

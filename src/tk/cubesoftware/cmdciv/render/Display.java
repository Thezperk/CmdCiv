package tk.cubesoftware.cmdciv.render;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame {
	RenderDevice render;
	
	public Display(int width, int height, int version) {
		super("CmdCiv v" + version);
		render.setPreferredSize(new Dimension(width, height));
		pack();
		setLocationRelativeTo(null);
		render.startGameLoop();
	}
	
	
	
	
}

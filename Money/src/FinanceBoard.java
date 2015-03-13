import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;


public class FinanceBoard extends JPanel implements ActionListener {

	private boolean gameOver;
	
	KeyListener listener = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			
			if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
			{
			}
			else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			{
			}
			else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
			{
			}
			else if(arg0.getKeyCode() == KeyEvent.VK_UP)
			{
			}
			else if(arg0.getKeyCode() == KeyEvent.VK_SPACE)
			{
			}
		}
	};

	public FinanceBoard()
	{
		setFocusable(true);
		gameOver = false;
		
		addKeyListener(listener);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();
	}
	
	public void paint(Graphics g)
	{	
		super.paint(g);
		
		g.drawRect(300, 20, 100, 30);
		g.drawString("GAME OVER!", 50, 50);
	}
}
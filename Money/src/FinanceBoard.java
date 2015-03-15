import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;
import java.lang.Object;


public class FinanceBoard extends JPanel implements ActionListener {

	private boolean gameOver;
	private User gameUser;
	private JButton  addMoneyToBank;
	private JOptionPane addMoneyPopup;
	
	private ActionListener addMoneyToBankAction;
	
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
		}
	};

	public FinanceBoard()
	{
		setFocusable(true);
		gameOver = false;
		
		gameUser = new User(0);
		addMoneyToBank = new JButton("Add To Bank");
		this.add(addMoneyToBank);
		addMoneyToBank.setLocation(0, 500);
		
		addKeyListener(listener);

		addMoneyPopup = new JOptionPane();
		
		addMoneyToBankAction = new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				String userResponse = addMoneyPopup.showInputDialog("How much money are you adding?");
				
				gameUser.addToTotalGain(Double.parseDouble(userResponse));
				System.out.println(gameUser.getTotalGain());
			}
		};
		
		addMoneyToBank.addActionListener(addMoneyToBankAction);
		
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();
	}
	
	public void paint(Graphics g)
	{	
		BufferedImage temp = null;
		try {
			temp = ImageIO.read(new File("/Users/arushibandi/Desktop/back.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		super.paint(g);
		g.drawImage(temp, 0, 50, null);
		addMoneyToBank.setLocation(0, 525);
		addMoneyToBank.setSize(100, 50);
		g.setColor(Color.green);
		g.fillRect(5, 5, 390, 40);
		g.setColor(Color.black);
		g.drawString("$1.01: learn finance fast!", 10, 30);
	}
}
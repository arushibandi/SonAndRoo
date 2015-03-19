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

	//addMoney
	private JButton  addMoneyToBank;
	private JOptionPane addMoneyPopup;
	private ActionListener addMoneyToBankAction;
	
	//removeMoney
	private JButton removeMoney;
	private JOptionPane removeMoneyPopup;
	private ActionListener removeMoneyAction;
	
	private Color lightGreen;
	

	
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
		
		//colors
		lightGreen = new Color(206,240,216);
		
		gameUser = new User(0);
		
		//addMoney
		addMoneyToBank = new JButton("Add To Bank");
		this.add(addMoneyToBank);
		addMoneyToBank.setLocation(0, 500);
		addMoneyPopup = new JOptionPane();
		
		//removeMoney
		removeMoney = new JButton("Remove Money");
		this.add(removeMoney);
		removeMoney.setLocation(200,500);
		removeMoneyPopup = new JOptionPane();
		
		
		//KeyListeners
		addKeyListener(listener);
		
		//addMoney Action Listener
		addMoneyToBankAction = new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				String userResponse = addMoneyPopup.showInputDialog("How much money are you adding?");
				
				gameUser.addToTotalGain(Double.parseDouble(userResponse));
				gameUser.updateInBank();
			}
		};
		
		addMoneyToBank.addActionListener(addMoneyToBankAction);
		
		//removeMoney Action Listener
		removeMoneyAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userResponse = removeMoneyPopup.showInputDialog("How much money did you spend?");
				gameUser.addToTotalSpent(Double.parseDouble(userResponse));
				gameUser.updateInBank();
				
			}
			
		};
		
		removeMoney.addActionListener(removeMoneyAction);		
	
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
		super.setBackground(lightGreen);
		g.drawImage(temp, 0, 50, null);
		addMoneyToBank.setLocation(0, 525);
		addMoneyToBank.setSize(100, 50);
		removeMoney.setLocation(250, 525);
		removeMoney.setSize(150, 50);
		g.setColor(Color.black);
		g.drawString("$1.01: learn finance fast!", 10, 30);
	}
}
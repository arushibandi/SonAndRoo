import javax.swing.JFrame;


public class FinanceApplication extends JFrame {

	JFrame frame;
	
	public FinanceApplication()
	{
		frame = new JFrame();
		frame.setSize(425, 500);
		FinanceBoard board = new FinanceBoard();
		frame.add(board);
		frame.setVisible(true);
	}
}

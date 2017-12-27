import javax.swing.*;

public class SwingHelloWorld 
{
	private static void createAndShowGUI()
	{
		JFrame frame = new JFrame("Hello world swing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel(" Hello wolrd ");
		frame.getContentPane().add(label);
		frame.pack();
		frame.setVisible(true);

	}
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				createAndShowGUI();
			}
		});
	}

}
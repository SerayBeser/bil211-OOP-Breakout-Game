import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameObject extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame("BreakOut");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		Start panel = new Start();
		frame.add(panel, BorderLayout.CENTER);
		frame.setBackground(Color.BLACK);
		
		frame.setSize(625, 475);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}

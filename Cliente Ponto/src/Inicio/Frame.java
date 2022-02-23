package Inicio;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Frame {
	public JFrame frame;
	
	public Frame(String a) {
		frame = new JFrame();
		frame.setBounds(0, 0, 300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Texto = new JLabel(a);
		Texto.setHorizontalAlignment(SwingConstants.CENTER);
		Texto.setFont(new Font("Arial", Font.PLAIN, 20));
		Texto.setBounds(10, 40, 264, 31);
		frame.getContentPane().add(Texto);
	}
}

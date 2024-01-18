import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Driver {
		private static Random rand = new Random();
		private static int guessThis = rand.nextInt(100) + 1;
	public static void main(String[] args) {
		
		// make this so that it clears the text when you click restart
		
		JFrame frame = new JFrame("Guess the number");
		frame.getContentPane().setBackground(new Color(191, 215, 234));
		
		JLabel instructions = new JLabel("Enter a number (1 - 100) and click the button to guess");
		instructions.setBounds(100, 20, 400, 30);
		instructions.setFont(new Font("Arial", Font.BOLD, 14));
		instructions.setForeground(new Color(31, 71, 78));

		JTextField inputBox = new JTextField();
		inputBox.setBounds(200, 50, 100, 30);
		inputBox.setHorizontalAlignment(JTextField.CENTER);
		
		JButton checkButton = new JButton("click to check!");
		checkButton.setBounds(175, 80, 150, 30);
		checkButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		JLabel correctLabel = new JLabel("correct!");
		correctLabel.setBounds(225, 110, 50, 30);
		correctLabel.setForeground(new Color(9, 161, 41));
		correctLabel.setVisible(false);
		
		JLabel wrongLabel = new JLabel();
		wrongLabel.setBounds(225, 110, 150, 30);
		wrongLabel.setForeground(new Color(227, 23, 10));
		wrongLabel.setVisible(false);
		
		JButton restartButton = new JButton("restart");
		restartButton.setBounds(200, 140, 100, 30);
		//black rectangle button with white text
		restartButton.setOpaque(true);
		restartButton.setBorderPainted(false); 	//esthetically same as .setBorder(null)
		restartButton.setBackground(Color.black);
		restartButton.setForeground(Color.white);
		restartButton.setVisible(false);
		
		
		checkButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String numString = inputBox.getText();
				int checkThis = Integer.parseInt(numString);
				
				if(checkThis == guessThis) {
					wrongLabel.setVisible(false);
					correctLabel.setVisible(true);
					restartButton.setVisible(true);
				} else {
					correctLabel.setVisible(false);
					
					if(checkThis < guessThis) {
						wrongLabel.setText("higher");
					} else if (checkThis > guessThis) {
						wrongLabel.setText("lower");
					}
					wrongLabel.setVisible(true);

				}
			}	
		});
		
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guessThis = rand.nextInt(100) + 1;

				wrongLabel.setVisible(false);
				correctLabel.setVisible(false);
				restartButton.setVisible(false);
				inputBox.setText("");
			}
		});
		
		frame.add(instructions);
		frame.add(inputBox);
		frame.add(checkButton);
		frame.add(correctLabel);
		frame.add(wrongLabel);
		frame.add(restartButton);

		//always in this order! or it messes things up!
		frame.setSize(550,200);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}

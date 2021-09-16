package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangmanCOde implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	Stack<String> words = new Stack<String>();
	String labelText = "";
	String used = "";

	void run() {

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String word = "";

		String y = JOptionPane.showInputDialog("Choose a number between 1 and 266");
		int amount = Integer.parseInt(y);
		for (int i = 0; i < amount; i++) {
			word = Utilities.readRandomLineFromFile("dictionary.txt");
			words.push(word);
		}
		for (int i = 0; i < word.length(); i++) {
			labelText += "_";
		}
		label.setText(labelText);
		used = words.pop();
		frame.add(label);
		frame.pack();
		frame.addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		String old = label.getText();
		String newtext = "";
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		char ch = key;
		for (int i = 0; i < used.length(); i++) {
			if (ch == used.charAt(i)) {
				newtext += ch;
			} else {
				newtext += old.charAt(i);
			}
		}
		label.setText(newtext);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

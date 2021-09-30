package _03_Hangman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class HangmanCOde implements KeyListener {
	JFrame frame ;
	JLabel label;
	Stack<String> words;
	String labelText;
	String used = "";
	int lives;
	void run() {
		frame= new JFrame();
		 label= new JLabel();
		 lives=5;
		 labelText = "";
		 words = new Stack<String>();
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
		int size=0;
		String old = label.getText();
		String newtext = "";
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		char ch = key;
		for (int i = 0; i < used.length(); i++) {
			if (ch == used.charAt(i)) {
				newtext += ch;
			} else {
				size+=1;
				newtext += old.charAt(i);
			}
		}
		if(newtext.equals(used)) {
			used=words.pop();		}
		else if(size==newtext.length()) {
			lives-=1;
		}
		 if(lives<=0) {
		int option=	JOptionPane.showOptionDialog(null, "Defeat  Do you wish to continue", "Defeat",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[] {
					"Continue","Quit" }, null);
		if(option==0) {
			frame.dispose();
			run();
			
		
		}
		else if(option==1) {
			System.exit(0);
		}
			//JOptionPane.showOp
		}
		label.setText(newtext+" Lives="+lives);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

package _00_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener{
    /* 
     * Create a JFrame with a JPanel and a JLabel.
     * Every time a key is pressed, add that character to the JLabel. It should
     * look like a basic text editor.
     * 
     * Make it so that every time the BACKSPACE key is pressed, the last
     * character is erased from the JLabel.
     * 
     * Save that deleted character onto a Stack of Characters.
     * 
     * Choose a key to be the Undo key. Make it so that when that key is
     * pressed, the top Character is popped  off the Stack and added back to
     * the JLabel.
     */

JFrame frame = new JFrame();
JLabel label = new JLabel();

Stack<Character> stack = new Stack<Character>();
String after ="";
String s="";
void run(){
	frame.add(label);
	frame.setVisible(true);
	frame.addKeyListener(this);
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {

	// TODO Auto-generated method stub
	char key = e.getKeyChar();
	char restored;
char ch= key;
s=label.getText();



	 if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
	    {  
		 if(s.length()>0){
		after=s.substring(0, s.length()-1);
		stack.push(s.charAt(s.length()-1));
		label.setText(after);
		s=after;
		 System.out.println(after);
		 }
		 System.out.println(stack);
	    }

	 else if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
		// System.out.println("restore");
		 if(!stack.isEmpty()) {
		 restored=stack.pop();
		
		 s=label.getText()+restored;	
		System.out.println(stack);
		 label.setText(s);
		 System.out.println(restored);
		 }

	 }
	 else {
		 s+=key;	

		 label.setText(s);

	 }
	 frame.repaint();
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
//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
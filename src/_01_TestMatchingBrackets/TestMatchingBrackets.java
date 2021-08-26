package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
    /*
     * Use a Stack to complete the method for checking if every opening bracket
     * has a matching closing bracket
     */
    public static boolean doBracketsMatch(String b) {
    	Stack<Character> curly = new Stack<Character>();

    	for(int i =0; i<b.length();i++) {
    		if(b.charAt(i)=='{') {
    			curly.push(b.charAt(i));
    		}
    		else if(b.charAt(i)=='}') {
    			if(curly.isEmpty()) {
    			return false;
    			}
    			
    			curly.pop();
    			
    		}
    
    	}
        if(curly.isEmpty()) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
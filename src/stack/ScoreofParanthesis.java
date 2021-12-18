/**
 * 
 */
package stack;

import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class ScoreofParanthesis {
	/*
	 * In this problem , we will make use of stack to keep track of brackets and Hashmap to keep the level count of paranthesis clusters.
	 * Leetcode problem 856
	 */
	public int scoreOfParentheses(String s) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//keep track of paranthesis level, if it is in same level add the same level paranthesis valuee or 2 * value of higher level paranthesis. 
        int stack = 0;
        for(int  i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		stack++;
        	}
        	if(s.charAt(i) == ')') {
        		int val = 1;
        		if(map.containsKey(stack + 1)) {//check level by level of score of paranthesis.
        			val = (2 * map.get(stack + 1));
        			map.remove(stack + 1);
        		}
                
        		if(map.containsKey(stack)) {
        			val += map.get(stack);
        			map.put(stack, val);//for same level, add the value(as given in question description).
        		}
                else {
                    map.put(stack, val);
                }
                stack--;
        	}
        }
        return map.get(1);
    }
}

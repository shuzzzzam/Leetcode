/**
 * 
 */
package stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author fSociety
 *
 */
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashSet<String> set = new HashSet<String>();
		for(int i = 0; i < s.length(); i++) {
			String str = s.substring(i, i + 1);
			if(map.containsKey(str)) {
				int val = map.get(str);
				map.put(str, val + 1);
			}
			else {
				map.put(str, 1);
			}
		}
		
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < s.length(); i++) {
			String str = s.substring(i, i + 1);
			if(stack.isEmpty() || (str.compareTo(stack.peek()) > 0)) {
				stack.push(str);
				set.add(str);
				
			}
			else {
				while((map.get(stack.peek()) >= 1) && (str.compareTo(stack.peek()) < 0)) {
					String pop = stack.pop();
					set.remove(pop);
				}
				if(!set.contains(str)) {
					stack.push(str);
					set.add(str);
				}
			}
			
			int val = map.get(str);
			map.put(str, val - 1);
		}
		
		String ans = "";
		
		for(int i = 0; i < stack.size(); i++) {
			ans = stack.pop() + ans; 
		}
		
		return ans.;
    }
}

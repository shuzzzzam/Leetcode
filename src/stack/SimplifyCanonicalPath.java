/**
 * 
 */
package stack;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author fSociety
 *
 */
public class SimplifyCanonicalPath {
	/*
	 * In this problem we used stack for putting folder value and depending on the value, we changed the stack (".." for previous & "." for current folder)
	 */
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<String>();
		StringTokenizer st = new StringTokenizer(path,"/");
		while(st.hasMoreTokens()) {
			String elem = st.nextToken();
			if(elem.equals("..")) {
				if(!stack.empty())
					stack.pop();
			}
			else if(elem.equals(".")) {
				continue;
			}
			else {
				stack.add(elem);
			}
		}
		
		String ans = "";
		while(!stack.isEmpty()) {
			String top = stack.pop();
			ans = top + ans;
			ans = "/" + ans;
		}
        if(ans.equals(""))
            return "/";
		return ans;
    }
}

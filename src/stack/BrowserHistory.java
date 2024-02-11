/**
 * 
 */
package stack;

import java.util.Stack;

/**
 * @author fSociety
 *
 */
public class BrowserHistory {
	
	Stack<String> urlStack = null;
	Stack<String> forward = null;
	public BrowserHistory(String homepage) {
		urlStack = new Stack<String>();
		forward = new Stack<String>();
    }
    
    public void visit(String url) {
        forward = new Stack<String>();
        urlStack.push(url);
    }
    
    public String back(int steps) {
        for(int i = 0; i < Math.min(steps, urlStack.size()); i++) {
        	forward.push(urlStack.pop());
        }
        return urlStack.peek();
    }
    
    public String forward(int steps) {
    	for(int i = 0; i < Math.min(steps, forward.size()); i++) {
    		urlStack.push(urlStack.pop());
        }
        return forward.peek();
    }
}

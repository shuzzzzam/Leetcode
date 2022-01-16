/**
 * 
 */
package stack;

/**
 * @author fSociety
 *
 */
public class TrappingRainWater {
	/*
	 * Leetcode 42
	 * In this problem,  we will solve using stack of heights from left side and right side.
	 */
	public int trap(int[] height) {
		int waterRetained = 0;
        int[] nextBigRight = new int[height.length];
        int[] nextBigLeft = new int[height.length];
        int[] stack = new int[height.length];
        int head = -1;
        for(int i = 0; i < height.length; i++) {
        	if(head == -1) {
        		nextBigLeft[i] = -1;
                stack[++head] = height[i];//To keep the height if it is highest from left side onwards
        	}
        	else {
        		if(stack[head] > height[i]) {
        			nextBigLeft[i] = stack[head]; //If the current height is smaller , don't add the height to stack since we are adding only highest height from left onwards.
        		}
        		else {
        			while((head != -1) && stack[head] <= height[i]) {
        				head--;
        			}
        			
        			if(head == -1) {
                        nextBigLeft[i] = -1;
                        stack[++head] = height[i];//Similar aaproach as explained above.
                    }
        				
        			else
        				nextBigLeft[i] = stack[head];
        		}
        	}
        }
        
        //Similar for right hand side greatest heights as explained above.
        head = -1;
        for(int i = height.length - 1; i >= 0 ; i--) {
        	if(head == -1) {
        		nextBigRight[i] = -1;
                stack[++head] = height[i];
        	}
        	else {
        		if(stack[head] > height[i]) {
        			nextBigRight[i] = stack[head];
        		}
        		else {
        			while((head != -1) && stack[head] <= height[i]) {
        				head--;
        			}
        			
        			if(head == -1) {
                        nextBigRight[i] = -1;
                        stack[++head] = height[i];
                    }
        				
        			else
        				nextBigRight[i] = stack[head];
        		}
        	}
        }
        
        for(int i = 0; i < height.length; i++) {
        	if(nextBigLeft[i] != -1 && nextBigRight[i] != -1) {//We know that if there is no greatest left and right, then water will not trap on this height.
        		waterRetained += Math.min(nextBigLeft[i], nextBigRight[i]) - height[i];
        	}
        }
        
        return waterRetained;
    }
}

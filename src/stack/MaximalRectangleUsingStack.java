/**
 * 
 */
package stack;

/**
 * @author fSociety
 *
 */
public class MaximalRectangleUsingStack {
	/*
	 * Leetcode 85
	 * This problem is an interesting extension of Largest area of Rectangle In Histogram Problem which we solved using monotonic stack.
	 * Here we have to make the height array from the binary matrix and for each row, we will calculate maxArea.
	 */
	public int maximalRectangle(char[][] matrix) {
        int[][] intMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++) {
        	if(matrix[0][i] == '0')
        		intMatrix[0][i] = 0;
        	else {
        		intMatrix[0][i] = 1;
        	}
        }
        /*
         * Below is the algo for creating height array
         */
        for(int i = 1; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == '1') {
        			intMatrix[i][j] = intMatrix[i - 1][j] + 1;
        		}
        		else {
        			intMatrix[i][j] = 0;
        		}
        	}
        }
        //Using it in max area in histogram algorithms.
        int ans = 0;
        for(int i = 0; i < intMatrix.length; i++) {
        	int area = largestRectangleArea(intMatrix[i]);
        	if(area > ans)
        		ans = area;
        }
        return ans;
    }
	
	public int largestRectangleArea(int[] heights) {
		/*
		 * This question uses the stack question in which we have to find the immediate less value in both left hand and right hand side.
		 * It is the addition of immediate least value to right and left  problem of stack
		 * Leetcode problem 84
		 **/
		
        int maxArea = 0;
        int[] stack = new int[heights.length];//stack to keep record of index for integer value in left hand and right side. 
        int head = -1;
        int[] area1 = new int[heights.length];//Array keeps track record of rectangle Area formed to the right hand side till lower value height is present. 
        int[] area2 = new int[heights.length];//Array keeps track record of rectangle Area formed to the left hand side till lower value height is present. 
        for(int i = heights.length - 1; i >= 0; i--) {
        	int Area = 0;
        	if(head == -1) {
        		Area = (heights[i] * (heights.length - i));
        	}
        	else {
        		while((head != -1) && (heights[stack[head]] >= heights[i])) {
        			--head;
        		}
        		if(head == -1) {
        			Area = (heights[i] * (heights.length - i));
        		}
        		else {
        			Area = (heights[i] * (stack[head] - i));
        		}
        	}
        	area1[i] = Area;//right hand side
        	stack[++head] = i;
        }
        head = -1;
        for(int i = 0; i < heights.length; i++) {
        	int Area = 0;
        	if(head == -1) {
        		Area = (heights[i] * (i + 1));
        	}
        	else {
        		while((head != -1) && (heights[stack[head]] >= heights[i])) {
        			--head;
        		}
        		if(head == -1) {
        			Area = (heights[i] * (i + 1));
        		}
        		else {
        			Area = (heights[i] * (i - stack[head]));
        		}
        	}
        	area2[i] = Area;//left hand side
        	stack[++head] = i;
        }
        
        //Now add the area of two superimposed rectangle formed in left hand side & right hand side. 
        for(int  i = 0; i < heights.length; i++) {
        	if(maxArea < (area1[i] + area2[i] - heights[i])) {
        		maxArea = (area1[i] + area2[i] - heights[i]);//addition of two areas will have extra area of (height[i] * 1) due to overlapping, that's why it is subtracted;
        	}
        }
        return maxArea;
    }
}

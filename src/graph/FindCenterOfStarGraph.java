/**
 * 
 */
package graph;

import java.util.HashSet;

/**
 * @author fSociety
 *
 */
public class FindCenterOfStarGraph {
	public int findCenter(int[][] edges) {
		/*
		 * Leetcode 1791
		 * In this question we have to analyse coordinates of only two points and then find the centre;
		 */
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < 2; i++) {
        	int a = edges[i][0];
        	int b = edges[i][1];
        	if(set.contains(a))
        		return a;
        	set.add(a);
        	if(set.contains(b))
        		return b;
        	set.add(b);
        	
        }
        return 0;
    }
}

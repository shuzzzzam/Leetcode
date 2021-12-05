/**
 * 
 */
package graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author fSociety
 *
 */
public class FindIfPathExistInGraph {
	public boolean validPath(int n, int[][] edges, int start, int end) {
		/*
		 * In this problem, we will solve the problem by using BFS algorithm to find if there is any path between two vertices.(Similar to Level order Traversal in trees)
		 */
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= (n - 1); i++) {
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	adjList.add(list);
        }
        
        for(int i = 0; i < edges.length; i++) {
        	int a = edges[i][0];
        	int b = edges[i][1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        ArrayList<Integer> queue = new ArrayList<Integer>();//Declare queue to put the vertices in FCFS manner.
        queue.add(start);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(start, 1);
        while(!queue.isEmpty()) {
        	int head = queue.remove(0);
        	if(head == end)
        		return true;
        	ArrayList<Integer> list = adjList.get(head);
        	for(int i = 0; i < list.size(); i++) {
        		
        		if(!map.containsKey(list.get(i))) {
        			queue.add(list.get(i));
        			map.put(list.get(i), 1);
        		}
        		/*if(list.get(i) == end)
        			return true;*/
        	}
        	
        }
        
        return false;
    }
}

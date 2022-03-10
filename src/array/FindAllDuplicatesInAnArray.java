/**
 * 
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author fSociety
 *
 */
public class FindAllDuplicatesInAnArray {
	/*
	 * Leetcode 442
	 * In this problem, we will use indirect hashing of hashmap size 'n' depending on the scenario of the question.
	 */
	public List<Integer> findDuplicates(int[] nums) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] map = new int[nums.length + 1];
        Arrays.fill(map, 0);
        
        int i = 0;
        while(i < nums.length) {
            if(nums[i] != (i + 1)) {//In this step, it is imperative to make element match it's index in the map(array form.)
                while(nums[i] != (i + 1)) {
                    int valueAtI = nums[i];
                    int valueAtPositionI = nums[valueAtI - 1];
                    if(valueAtI == valueAtPositionI) {
                    	if(map[valueAtI] == 0) {
                    		map[valueAtI] += 1;
                    		ans.add(valueAtI);
                    	}
                        break;
                    }
                    
                    int temp = valueAtI;
                    nums[i] = valueAtPositionI;
                    nums[temp - 1] = temp;
                }
            }
            i++;
        }
        return ans;
    }
}

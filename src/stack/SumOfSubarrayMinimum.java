/**
 * 
 */
package stack;

/**
 * @author fSociety
 *
 */
public class SumOfSubarrayMinimum {
	/*
	 * In this problem, we made use of monotonic stack of next lower element in right side of array.
	 */
	public int sumSubarrayMins(int[] arr) {
        int[] nextLower = new int[arr.length];
        int[] sumArray = new int[arr.length];
        int[] stack = new int[arr.length];
        int head = -1, sum = 0;
        for(int i = arr.length - 1; i >= 0; i--) {//To create a monotonic stack of next lower element in array
        	int num = arr[i];
        	while((head != -1) && (arr[stack[head]] >= num)) {
        		head--;
        	}
        	if(head == -1)
        		nextLower[i] = -1;
            else {
                nextLower[i] = stack[head];//keeping track of next lower element index.
            }
        	stack[++head] = i;
        }
        
        for(int i = arr.length - 1; i >= 0; i--) {
        	int nextLowerIndex = nextLower[i];
        	int indexSum = 0;
        	if(nextLowerIndex == -1) {
        		indexSum = (((arr[i] % 1000000007) * ((arr.length - i) % 1000000007)) % 1000000007);//go till end of the array(for all continues element array permutations) as the element itself is minimum
        	}
        	else {
        		indexSum = (((((arr[i] % 1000000007) * ((nextLowerIndex - i) % 1000000007)) % 1000000007)  + (sumArray[nextLowerIndex] % 1000000007)) % 1000000007);//go till lower minimum number index and add the sum value of the lowerIndex to the current index evaluation. 
        	}
        	sumArray[i] = (indexSum % 1000000007);
        	sum =  (((sum % 1000000007) + (indexSum % 1000000007)) % 1000000007);
            
        }
        
        return sum;
        
    }
}

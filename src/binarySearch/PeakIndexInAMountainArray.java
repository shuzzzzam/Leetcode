package binarySearch;

public class PeakIndexInAMountainArray {

	public int peakIndexInMountainArray(int[] arr) {
		public int peakIndexInMountainArray(int[] arr) {
			int start = 0, end = arr.length - 1;
			while(start < end) {
	    	   
	    	   if(end - start == 1) {
	    		   if(arr[start] > arr[end])
	    			   return start;
	    		   else
	    			   return end;
	    	   }
	    	   
	    	   int mid = (start + end) / 2;
	    	   if(arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
	    		   return mid;
	    	   
	    	   
	    	   if(arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
	    		   start = mid;
	    		   
	    	   }
	    	   else {
	    		   end = mid;
	    	   }
	       }
	       
	       return 0;
	    }
        
    }

}

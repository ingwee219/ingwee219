public class Solution_643_MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        
        long sum = 0;
        for (int i = 0; i < k; i++) {
        	sum += nums[i];
        }
        double max = sum;
        
        
    	for (int i = 0; i < nums.length-k; i++ ) {
    		sum = sum -nums[i]+nums[i+k];
    		
    		if (sum>max) max = sum;
    	}
    	
    	max/=k;
    	
    	return max;
    }
}

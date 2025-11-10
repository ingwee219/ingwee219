import java.util.*;
public class Solution_3349_AdjacentIncreasingSubarraysDetection {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        if (k*2>nums.size()) return false;
        if (k ==1 && nums.size()>1) return true;
    	int cnt1 = 1;
    	
    	
    	for (int i = 0 ; i < nums.size()-k; i++) {
    		boolean isSameSub = false;
    		if(i>0 && nums.get(i-1) <nums.get(i) && cnt1 < k) {
    			cnt1++;
    		} else if (i>0 && nums.get(i-1) >= nums.get(i)) {
    			cnt1 = 1;
    		}
    		
    		if (cnt1 == k) {
    			for (int j = i+1; j < i+k; j++) {
    				if (nums.get(j) >= nums.get(j+1)) {
    					isSameSub = false;
    					break;
    				} else {
    					isSameSub = true;
    				}
    				
    			}
    		}
    		
    		
    		
    		
    		if(isSameSub) return true;
    		
    	}
        
        
        
    	return false;
    }
}

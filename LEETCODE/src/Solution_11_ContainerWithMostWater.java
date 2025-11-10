
public class Solution_11_ContainerWithMostWater {
    public int maxArea(int[] height) {
    	int n = height.length;
        int max = 0;
    	int l = 0;
    	int r = n-1;
    	
    	while (l != r) {
    		if (max < (r-l)*Math.min(height[l], height[r])) max = (r-l)*Math.min(height[l], height[r]);
    		
    		if (height[l] <= height[r]) {
    			l++;
    		} else {
    			r--;
    		}
    	}
        
        
        
    	return max;
    }
}

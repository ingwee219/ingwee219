import java.util.*;

public class Solution_3346_MFEAPO {
	public int maxFrequency(int[] nums, int k, int numOperations) {
		int r = numOperations;
		int n = nums.length;
		int maxF = 1;
		Arrays.sort(nums);

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i]))
				map.put(nums[i], map.get(nums[i]) + 1);
			else
				map.put(nums[i], 1);
		}

		int[] kk = new int[nums[n - 1]+1];
		int nowRange = 0;
		
		for (int i = nums[0]; i <= nums[0] + k; i++) {
			if (map.containsKey(i)) nowRange += map.get(i);
		}
		
		
		
		for (int i = nums[0]; i < nums[n - 1]+1; i++) {
			int max = 0;
			int currNum = 0;
			if (map.containsKey(i)) {
				currNum = map.get(i);
			}
			
			if (nowRange-currNum < r) {
				max = nowRange;
			} else {
				max = r+currNum;
			}
			
			kk[i] = max;
			
			
			if (map.containsKey(i-k)) nowRange -= map.get(i-k);
			if (map.containsKey(i+k+1)) nowRange += map.get(i+k+1);
		}
		
		
		
		
		for (int i : kk) {
			if (i > maxF) maxF = i;
		}
		
		
		return maxF;
	}
}

import java.util.*;

public class Solution_1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] indices = new int[2];
		int n = nums.length;
		
//		int[] sorted = nums;
//		Arrays.sort(sorted);
//		int min = sorted[0];
//		int max = sorted[n - 1];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (map.containsKey(nums[i])) {
				if (target == nums[i]*2) {
					indices[0] = i;
					indices[1] = map.get(nums[i]);
					return indices;
				}
			} else {
				map.put(nums[i], i);
				set.add(nums[i]);
			}
		}
		
		for(int x : set) {
			if (set.contains(target-x)) {
				indices[0] = map.get(x);
				indices[1] = map.get(target-x);
				return indices;
			}
		}
		
		

		return indices;
	}
}

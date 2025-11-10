import java.util.*;

public class Solution_3321_FindXSumOfAllKLongSubarraysII {
	public long[] findXSum(int[] nums, int k, int x) {
		int n = nums.length;
		long[] ans = new long[n - k + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < n - k + 1; i++) {// 첫 subarray의 빈도 저장
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
				set.add(nums[i]);
			}
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>();
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>();

		
		
		
		if (set.size() <= x) {
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += nums[i];
			}
			ans[0] = sum;
		} else {
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				pq.offer(entry);
				
			}
			
			
			
		}

		for (int i = 0; i < n - k + 1; i++) {

		}

		return ans;
	}

}

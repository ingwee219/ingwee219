import java.util.*;
public class Solution_2215_FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new LinkedList<>(); 
    	List<Integer> a1 = new LinkedList<>();
    	List<Integer> a2 = new LinkedList<>();
    	Set<Integer> set1 = new HashSet<>();
    	Set<Integer> set2 = new HashSet<>();
    	for (int i = 0; i < nums1.length; i++) {
    		set1.add(nums1[i]);
    	}
    	for (int i = 0; i < nums2.length; i++) {
    		set2.add(nums2[i]);
    	} 
    	
    	for (int i : set1) {
    		if (!set2.contains(i)) a1.add(i);
    	}
    	for (int i : set2) {
    		if (!set1.contains(i)) a2.add(i);
    	}
    	ans.add(a1);
    	ans.add(a2);
    	
    	return ans;
    }
}

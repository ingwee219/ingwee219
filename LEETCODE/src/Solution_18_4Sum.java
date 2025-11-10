import java.util.*;
public class Solution_18_4Sum {
	static List<List<Integer>> quads; 
	static List<Integer> comb;
    public List<List<Integer>> fourSum(int[] nums, int t) {
    	comb = new LinkedList<>();
    	quads = new LinkedList<>(); 
    	combination(0,0,nums,t);
    	
    	return quads;
    }
    
    static void combination(int idx, int start, int[] nums, int t) {

    }
    
}


public class Solution_746_MinCostClimbingStairs {

	static int[] memoMin;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
    	int[] memoMin = new int[n];
    	for (int i = 0; i < n ; i ++) {
    		memoMin[i] = -1;
    	}
    	memoMin[0] = cost[0];
    	memoMin[1] = cost[1];
    	
    	return Math.min(dp(cost,memoMin,n-2), dp(cost,memoMin,n-1));
    }
    
    
    public int dp (int[] cost, int[] memo, int idx) { // 해당idx까지 도달할 때까지의 min cost를 구하는 함수.
    	if (memo[idx] != -1) return memo[idx];
    	
    	
    	if(dp(cost,memo,idx-1) < dp(cost,memo,idx-2))  {
    		memo[idx] = dp(cost,memo,idx-1) + cost[idx];
    		return memo[idx];
    		} 
    	memo[idx] = dp(cost,memo,idx-2) + cost[idx];
    	return memo[idx];
    }
    
    
}

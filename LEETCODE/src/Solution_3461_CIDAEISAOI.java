public class Solution_3461_CIDAEISAOI {

	static int[][] memo;
	static boolean[][] visited;
    public static boolean hasSameDigits(String s) {
        int n = s.length();
        long[] numRep = new long[n-1];
        memo = new int[n][n];
        visited = new boolean[n][n];
        
        
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < n-1; i++) {
        	numRep[i] = pascal(n-1,i);
        }

        for (int i = 0; i < n-1; i++ ) {
        	sum1 += (long)s.charAt(i)*numRep[i];
        	sum2 += (long)s.charAt(i+1)*numRep[i];
        }
        
        
        String s1 = String.valueOf(sum1);
        String s2 = String.valueOf(sum2);
        if (s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1))
        	return true;
    	
    	return false;
    }
    
    
    
    public static int pascal(int n, int idx) {
    	if (visited[n][idx]) return memo[n][idx];
    	if (n == 2) return 1;
    	if (idx == 0) return 1;
    	if (idx >= n-1) return 1;
    	
    	
    	memo[n][idx] = pascal(n-1,idx-1) + pascal(n-1,idx);
    	visited[n][idx] = true;
    	return memo[n][idx];
    }
    
    
}


public class Solution_2125_NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
    	int cnt = 0;
        int m = bank.length;
        int n = bank[0].length();
        int[] ones = new int[m];
        int idx = -1;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (bank[i].charAt(j) == '1') {
        			ones[i]++;
        		}
        	}
        }
        
        for (int i = 0; i < ones.length; i++) {
        	if (ones[i] == 0) continue;
        	if (idx == -1) {idx = i; continue;}
        	cnt += ones[i] * ones[idx];
        	idx = i;
        	
        }
        
    	return cnt;
    }
}

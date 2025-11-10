

public class Solution_1578_MTMRC {
	public int minCost(String colors, int[] neededTime) {
		int n = neededTime.length;
		if (n ==1) return 0;
		int time = 0;
		int currNum = 0;
		int maxCostThisColor = 0;
		int timeThisColor = 0;

		for (int i = 0; i < n-1; i++) { 
			currNum++; 
			
			if (colors.charAt(i) != colors.charAt(i+1)) {
				
				if (currNum == 1) {
					currNum = 0;
					maxCostThisColor = 0;
					timeThisColor = 0;
					continue;
				}
				
				if (neededTime[i] > maxCostThisColor) maxCostThisColor = neededTime[i];
				timeThisColor += neededTime[i];
				timeThisColor -= maxCostThisColor;
				time += timeThisColor;
				currNum = 0;
				maxCostThisColor = 0;
				timeThisColor = 0;
				
			} else { 
				if (neededTime[i] > maxCostThisColor) maxCostThisColor = neededTime[i];
				timeThisColor += neededTime[i];
			}
			
		}
			
		if ( colors.charAt(n-2) == colors.charAt(n-1)) {
				if (neededTime[n-1] > maxCostThisColor) maxCostThisColor = neededTime[n-1];
				timeThisColor += neededTime[n-1];
				timeThisColor -= maxCostThisColor;
				time += timeThisColor;
		}

		return time;
	}
}


//1, 5, 10 -> 그냥 반복문으로 나눠서 몫/나머지 처리 (배수관계가 있으면 가능)

import java.util.Arrays;

public class 동적계획법_02_동전거스름돈 {
	public static void main(String[] args) {
		//활용할 수 있는 동전 1, 4, 6 
		
		
		int money = 10; //8원 4,4
		int[] dp = new int[money+1]; //8원까지는 거슬러줘야대
		
		for(int i = 1; i<=money; i++) {
			int minCount = Integer.MAX_VALUE;
			
			//1원을 고려하자! (1원전의 값에 1원 동전 한개 추가)
			minCount = Math.min(minCount, dp[i-1]+1);
			//4원을 고려하자!
			if(i>=4)	  //(1원을 이용하여 거슬러준 경우, 4원전의 값에 4원 동전을 한개 추가)
				minCount = Math.min(minCount, dp[i-4]+1);
			//6원을 고려하자!
			if(i>=6) 	  //(1원, 4원을 이용하여 거슬러준 경우, 6원전의 값에 6원 동전을 한개 추가)
				minCount = Math.min(minCount, dp[i-6]+1);
			//////////////////////////
			dp[i] = minCount; //i원을 거슬러주려고 했을때 모든 동전을 고려했고, 가장 작은 값이 들어가 있다.
		}
		
		System.out.println(Arrays.toString(dp));
		
	}
}

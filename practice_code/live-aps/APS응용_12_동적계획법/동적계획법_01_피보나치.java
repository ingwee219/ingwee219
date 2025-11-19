import java.util.Arrays;

public class 동적계획법_01_피보나치 {
	
	static int[] memo = new int[1000];
	static {
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1;
	}
	public static void main(String[] args) {
		System.out.println(fibo(60));
		
	}
	
	
	static int fibo(int N) {
		//fibo(N) 뭔지 몰라~
		if(memo[N] == -1) {
			memo[N] = fibo(N-1)+fibo(N-2);
		}
		return memo[N];
	}
	
	static int fibo2(int N) {
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i<= N; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[N];
	}
	
}

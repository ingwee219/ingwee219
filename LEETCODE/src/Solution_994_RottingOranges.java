import java.util.*;



public class Solution_994_RottingOranges {
	static int[] nr = { -1, 1, 0, 0 };
	static int[] nc = { 0, 0, -1, 1 };

	static class coord {
		int r;
		int c;
		int g;
		public coord(int r, int c, int g) {
			this.r = r;
			this.c = c;
			this.g = g;
		}

	}
	
	static public int orangesRotting(int[][] grid) {
		int[][] map = grid;
		int m = map.length;
		int n = map[0].length;
		int[][] g = new int[m][n];
		int minutes = 0;

		Queue<coord> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 2) {
					q.add(new coord(i, j, 0));
				}
			}
		}

		while (!q.isEmpty()) {
			int curR = q.peek().r;
			int curC = q.peek().c;
			int curG = q.peek().g;
			q.poll();
			
			for (int k = 0; k < 4; k++) {//4방향중 1이 나오면 
				if (curR + nr[k] >= 0 && curR + nr[k] < m && curC + nc[k] >= 0 && curC + nc[k] < n
						&& map[curR + nr[k]][curC + nc[k]] == 1) {
					q.add(new coord(curR + nr[k], curC + nc[k], curG+1) );
					map[curR + nr[k]][curC + nc[k]] = 2; // 해당 요소 2로 바꿈
					g[curR + nr[k]][curC + nc[k]] = curG+1;//세대 기록
				}
			}
			
		}
		
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) return -1;
				if (g[i][j]> minutes) minutes = g[i][j];
			}
		}
		
		
		
		return minutes;
	}// orangeRotting

}

import java.util.*;
class Solution_2607_PowerGridMaintenance {
  static class DSU {
        int[] p, r;
        DSU(int n) {
            p = new int[n+1];
            r = new int[n+1];
            for (int i = 1; i <= n; i++) p[i] = i;
        }
        int find(int x) {
            if (p[x] != x) p[x] = find(p[x]);
            return p[x];
        }
        void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            if (r[ra] < r[rb]) p[ra] = rb;
            else if (r[ra] > r[rb]) p[rb] = ra;
            else { p[rb] = ra; r[ra]++; }
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // 1) 연결성 고정: DSU
        DSU dsu = new DSU(c);
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0], v = connections[i][1];
            dsu.union(u, v);
        }

        // 2) 온라인 상태 & 컴포넌트별 온라인 TreeSet
        boolean[] online = new boolean[c+1];
        Arrays.fill(online, true);

        Map<Integer, TreeSet<Integer>> compOnline = new HashMap<>();
        for (int node = 1; node <= c; node++) {
            int root = dsu.find(node);
            compOnline.computeIfAbsent(root, k -> new TreeSet<>()).add(node);
        }

        // 3) 쿼리 처리
        ArrayList<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            if (type == 1) {
                if (online[x]) {
                    res.add(x);
                } else {
                    int r = dsu.find(x);
                    TreeSet<Integer> set = compOnline.get(r);
                    res.add((set == null || set.isEmpty()) ? -1 : set.first());
                }
            } else { // type == 2
                if (online[x]) {
                    online[x] = false;
                    int r = dsu.find(x);
                    TreeSet<Integer> set = compOnline.get(r);
                    if (set != null) set.remove(x);
                }
            }
        }

        // 4) 배열 변환
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
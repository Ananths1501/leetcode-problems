import java.util.ArrayList;

class Solution {

    public void dfs(int i, int[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = 1;
        for (int a : adj.get(i)) {
            if (visited[a] == 0) {
                dfs(a, visited, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        int count = 0;
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }
}

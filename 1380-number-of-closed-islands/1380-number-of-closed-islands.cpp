class Solution {
public:
    int m,n;
    void dfs(int i, int j, vector<vector<int>>& grid, bool& closed) {
        if(i<0 || j<0 || i==m || j==n){
            closed = false;
            return;
        }

        if(grid[i][j] == 1) return;
        grid[i][j] = 1;
        
        dfs(i+1, j, grid, closed);
        dfs(i-1, j, grid, closed);
        dfs(i, j+1, grid, closed);
        dfs(i, j-1, grid, closed);
    }

    int closedIsland(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();

        int cnt = 0;

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(grid[i][j] == 0) {
                    bool closed = true;
                    dfs(i, j, grid, closed);
                    if(closed) cnt++;
                }
            }
        }

        return cnt;
    }
};

class Solution {
public:
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        
       vector<vector<int>> dp = matrix;
        
        for (int row = 1; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                int minAbove = dp[row - 1][col]; 
                if (col > 0) {
                    minAbove = std::min(minAbove, dp[row - 1][col - 1]);
                }
                if (col < n - 1) {
                    minAbove = std::min(minAbove, dp[row - 1][col + 1]);
                }
                
                dp[row][col] += minAbove;
            }
        }
        
        return *min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
};
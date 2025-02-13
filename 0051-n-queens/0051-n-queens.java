class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
       boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // r - c diagonal
        boolean[] diag2 = new boolean[2 * n - 1]; // r + c diagonal
        backtrack(result, new ArrayList<>(), n, 0, cols, diag1, diag2);
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<String> currentBoard, int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            result.add(new ArrayList<>(currentBoard));
            return;
        }
        
        for (int col = 0; col < n; col++) {
             if (cols[col] || diag1[row - col + n - 1] || diag2[row + col]) {
                continue;
            }
            
            cols[col] = true;
            diag1[row - col + n - 1] = true;
            diag2[row + col] = true;
            StringBuilder rowString = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == col) {
                    rowString.append("Q");
                } else {
                    rowString.append(".");
                }
            }
            currentBoard.add(rowString.toString());
            
            backtrack(result, currentBoard, n, row + 1, cols, diag1, diag2);
            
            currentBoard.remove(currentBoard.size() - 1);
            cols[col] = false;
            diag1[row - col + n - 1] = false;
            diag2[row + col] = false;
        }
    }
}
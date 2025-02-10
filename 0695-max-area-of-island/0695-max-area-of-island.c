#include <stdio.h>

void dfs(int** grid, int gridSize, int* gridColSize, int x, int y, int* area) {
    // Base conditions: check boundaries and if the cell is water (0)
    if (x < 0 || y < 0 || x >= gridSize || y >= *gridColSize || grid[x][y] == 0) {
        return;
    }
    
    // Mark the cell as visited by sinking the land (changing 1 to 0)
    grid[x][y] = 0;
    
    // Increment the area of the island
    (*area)++;

    // Visit all four directions
    dfs(grid, gridSize, gridColSize, x + 1, y, area); // down
    dfs(grid, gridSize, gridColSize, x - 1, y, area); // up
    dfs(grid, gridSize, gridColSize, x, y + 1, area); // right
    dfs(grid, gridSize, gridColSize, x, y - 1, area); // left
}

int maxAreaOfIsland(int** grid, int gridSize, int* gridColSize) {
    int maxArea = 0;

    for (int i = 0; i < gridSize; i++) {
        for (int j = 0; j < *gridColSize; j++) {
            // If the current cell is land (1)
            if (grid[i][j] == 1) {
                int area = 0; // Initialize the area for this island
                dfs(grid, gridSize, gridColSize, i, j, &area); // Run DFS to calculate area
                if (area > maxArea) {
                    maxArea = area; // Update max area if this one is larger
                }
            }
        }
    }
    return maxArea;
}
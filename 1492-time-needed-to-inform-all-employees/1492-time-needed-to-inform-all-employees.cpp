class Solution {
public:
    int dfs(int emp_id, unordered_map<int, vector<int>>& subordinates, vector<int>& informTime) {
        int max_time = 0;
        for (int sub : subordinates[emp_id]) {
            max_time = max(max_time, dfs(sub, subordinates, informTime));
        }
        return informTime[emp_id] + max_time;
    }

     int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        unordered_map<int, vector<int>> subordinates;
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                subordinates[manager[i]].push_back(i);
            }
        }
        return dfs(headID, subordinates, informTime);
    }
};
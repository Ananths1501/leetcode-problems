class Solution {

    public int f(int i,int prev,int nums[],int dp[][]){
        if(i==nums.length)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];
        int notpick= f(i+1,prev,nums,dp);
        int pick=0;
        if(prev==-1 || nums[i]>nums[prev]){
            pick=1+ f(i+1,i,nums,dp);
        }
        dp[i][prev+1] = Math.max(pick,notpick);
        return dp[i][prev+1];
    }

    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        int dp[][]= new int[n][n];

        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int res= f(0,-1,nums,dp);
        return res;
    }
}
class Solution {

    int f(int i, int []nums, int []dp){
        if(i<0){
            return 0;
        }
        if(i==0)return nums[0];
        if(dp[i]!=-1)return dp[i];
        dp[i] = Math.max(nums[i]+f(i-2,nums,dp), f(i-1,nums,dp));
        return dp[i];
    }
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int ans=f(nums.length-1,nums,dp);
        return ans;
    }
}
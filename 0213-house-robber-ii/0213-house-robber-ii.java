class Solution {

    int f(int i, int []nums, int []dp){
        if(i<0){
            return 0;
        }
        if(i==0)return nums[0];
        if(dp[i]!=-1)return dp[i];

        int pick = nums[i]+f(i-2,nums,dp);
        int notpick = f(i-1,nums,dp);
        dp[i] = Math.max(pick, notpick);
        return dp[i];
    }
    public int rob(int[] nums) {

        int n=nums.length;
        if(n==1)return nums[0];
        int[] num1 = new int[n-1];
            System.arraycopy(nums, 0, num1, 0, n-1);
        int[] num2 = new int[n-1];
            System.arraycopy(nums, 1, num2, 0, n-1);

        int []dp=new int[n];
        Arrays.fill(dp,-1);
        int ans1=f(num1.length-1,num1,dp);
        Arrays.fill(dp,-1);
        int ans2=f(num2.length-1,num2,dp);
     
        //int ans=max(f(nums.length-1,nums,dp),f(nums.length-1,nums,dp));
        return Math.max(ans1,ans2);
    }
}
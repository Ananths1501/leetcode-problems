class Solution {

    public int f(int i, int amount,int []coins,int dp[][]){
        if(amount==0)return 1;
        if(dp[i][amount]!=-1)return dp[i][amount];
        if(i==0){
            if(amount%coins[i]==0)return 1;
            return 0;
        }
        int notpick=f(i-1,amount,coins,dp);
        int pick=0;
      if(coins[i]<=amount){
        pick=f(i,amount-coins[i],coins,dp);
      }
        return dp[i][amount]=pick+notpick;
    }
    public int change(int amount, int[] coins) {
        if(amount==0)return 1;

        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int []row:dp){
        Arrays.fill(row,-1);
        }
        int ans=f(coins.length-1,amount,coins,dp);
        return ans;
    }
}
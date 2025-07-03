class Solution {


    public int f(int i,int[] prices,int buy,int t,int dp[][][]){
        if(i==prices.length || t==0)return 0;
        if(dp[i][buy][t]!=-1) return dp[i][buy][t];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+f(i+1,prices,0,t,dp),f(i+1,prices,1,t,dp));
        }
        else{
            profit=Math.max(prices[i]+f(i+1,prices,1,t-1,dp),f(i+1,prices,0,t,dp));
        }

        return dp[i][buy][t]=profit;
    }
    public int maxProfit(int[] prices) {
        
        int dp[][][]=new int[prices.length][2][3];

        for(int [][]m:dp){
            for(int []n : m){
                Arrays.fill(n,-1);
            }
        }
        int res=f(0,prices,1,2,dp);
        return res;
    }
}
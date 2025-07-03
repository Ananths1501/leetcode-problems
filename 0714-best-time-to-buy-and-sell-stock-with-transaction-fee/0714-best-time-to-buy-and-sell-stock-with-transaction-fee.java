class Solution {


    public int f(int i,int[] prices,int buy,int dp[][],int fee){
        if(i==prices.length)return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[i]+f(i+1,prices,0,dp,fee),f(i+1,prices,1,dp,fee));
        }
        else{
            profit=Math.max(prices[i]+(f(i+1,prices,1,dp,fee)-fee),f(i+1,prices,0,dp,fee));
        }

        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices,int fee) {
        
        int dp[][]=new int[prices.length][2];

        
            for(int []n : dp){
                Arrays.fill(n,-1);
            }
        
        int res=f(0,prices,1,dp,fee);
        return res;
    }
}
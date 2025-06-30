class Solution {
    static Boolean f(int i,int arr[],int target,int dp[][]){
        if(target==0)return true;
        if(i==0){
           return arr[0]==target;
        }
        if(dp[i][target]!=-1){
            return dp[i][target]==1?true:false;
        }
        Boolean pick=false;
        Boolean notpick=f(i-1,arr,target,dp);
        if(arr[i]<=target){
            pick=f(i-1,arr,target-arr[i],dp);
        }
        
        dp[i][target]=pick || notpick?1:0;
        return pick || notpick;
    }
    public boolean canPartition(int[] arr) {
        
         int s = Arrays.stream(arr).sum();

        if(s%2!=0)return false;

        int n=arr.length;
        int dp[][]=new int[n][s+1];
        for(int []row:dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,arr,s/2,dp);
    }
}
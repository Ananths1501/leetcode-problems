class Solution {
    public int uniquePaths(int m, int n) {
        
        int i,j;
        int arr[][]=new int[m][n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(i==0 || j==0){
                    arr[i][j]=1;
                }
                else{
                arr[i][j]=arr[i][j-1]+arr[i-1][j];
                }
            }
        }
        return arr[m-1][n-1];
    }

}
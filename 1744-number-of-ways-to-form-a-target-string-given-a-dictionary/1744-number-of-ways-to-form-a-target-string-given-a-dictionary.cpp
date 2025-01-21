class Solution {
public:
    const long long mod=1e9+7;
    long long numWays(vector<string>& words, string target) {
        long long p=words.size();
        long long n=words[0].size();
        long long m=target.size();
        vector<long long> dp(m, 0);
        for(long long i=0;i<n;i++){
            vector<long long> hasher(26, 0);
            for(long long j=0;j<p;j++){//hashing all characters 
                hasher[words[j][i]-'a']++;
            }
            for(long long j=min(m, i+1)-1; j>=max(0LL, m+i-n);j--){
                if(j!=0)
                dp[j]=((hasher[target[j]-'a']*dp[j-1])%mod+dp[j])%mod;
                else//edge case
                dp[j]=(hasher[target[j]-'a']+dp[j])%mod;
            }
        }
        return dp[m-1];
    }
};
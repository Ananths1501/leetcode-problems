
int sumofdigits(int num) {
    int s = 0;
    while (num > 0) {
        s += (num % 10);
        num /= 10;
    }
    return s;
}

int maximumSum(int* nums, int n) {
    int maxsum = -1;
    int hash[100] = {0};  

    for (int i = 0; i < n; i++) {
        int sod = sumofdigits(nums[i]); 
        
        if (hash[sod] > 0) {
            int sum = hash[sod] + nums[i];  
            if (sum > maxsum) {
                maxsum = sum;  
            }
        }
        
        if (nums[i] > hash[sod]) {
            hash[sod] = nums[i];
        }
    }
    
    return maxsum;
}
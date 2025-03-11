int reverse(int n){
    int r=0;
    int i=0;
    while(n>0){
        r=r*10+(n%10);
        n/=10;
    }
    return r;
}
bool isSameAfterReversals(int num) {
    
    int n=reverse(num);
    n=reverse(n);
    return n==num;
}
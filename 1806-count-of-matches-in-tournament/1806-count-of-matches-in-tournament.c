int numberOfMatches(int n){
int total=0;
while(n>1){
    if(n%2!=0){
        total+=(n/2)+1;
    }
    else{
        total+=n/2;
    }
    n=n/2;
}
return total;
}
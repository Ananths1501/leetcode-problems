int addDigits(int num){
    int s=num;
    int sum=0;
    while(num>0){
        sum+=(num%10);
        num/=10;
    }
   if(sum>9){
    return addDigits(sum);
   }
   else{
    return sum;
   }
    
}
int passThePillow(int n, int time) {
    if (time < n) 
        return time + 1;
    
    int p = time % (2 * n - 2);
    
    if (p < n) 
        return p + 1;
    else 
        return 2 * n - 1 - p;
}

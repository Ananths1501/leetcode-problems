bool areOccurrencesEqual(char* s) {
    int i,j,n;
    n=strlen(s);
    printf("%d",n);
    int freq[26]={0};
    for(i=0;i<n;i++){
        freq[s[i]-'a']++;
    }
    int tf=0;
    for(i=0;i<26;i++){
        if(freq[i]>0){
        tf=freq[i];
        break;
        }
    }
    for(i=0;i<26;i++){
        if(freq[i]!=tf && freq[i]>0)return 0;
    }

    return 1;
}
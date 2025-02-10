char* clearDigits(char* s) {
    int n = strlen(s);
    while (1) {
        int removed = 0;
        for (int i = 0; i < n; i++) {
            if (isdigit(s[i])) {
                for (int j = i - 1; j >= 0; j--) {
                    if (isalpha(s[j])) {
                        for (int k = j; k < n - 2; k++) {
                            s[k] = s[k + 2];
                        }
                        n -= 2;
                        s[n] = '\0';
                        removed = 1;
                        break;
                    }
                }
                break;
            }
        }
        if (!removed) break;
    }
    return s;
}
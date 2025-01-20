#include <stdlib.h>
#include <string.h>

char* removeOuterParentheses(char* s) {
    int n = strlen(s);
    char* res = (char*)malloc((n + 1) * sizeof(char)); 
    int top = -1, count = 0;

    for (int i = 0; i < n; i++) {
        if (s[i] == '(') {
            if (count > 0) { 
                res[++top] = s[i];
            }
            count++;
        } else {
            count--;
            if (count > 0) {
                res[++top] = s[i];
            }
        }
    }

    res[++top] = '\0';
    return res;
}

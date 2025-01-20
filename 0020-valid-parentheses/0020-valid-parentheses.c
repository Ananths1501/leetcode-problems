#include <stdbool.h>
#include <string.h>

bool isValid(char* s) {
    char c[10000]; 
    int top = -1; 
    
    for (int i = 0; i < strlen(s); i++) {
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            c[++top] = s[i]; 
        } else {
            if (top == -1) { 
                return false;
            }
            if ((s[i] == ')' && c[top] == '(') ||
                (s[i] == ']' && c[top] == '[') ||
                (s[i] == '}' && c[top] == '{')) {
                top--; 
            } else {
                return false; 
            }
        }
    }
    
    return top == -1;
}
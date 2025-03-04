
bool isMatchHelper(const char* s, const char* p) {
    if (*p == '\0') {
        return *s == '\0';
    }

    bool first_match = (*s != '\0' && (*s == *p || *p == '.'));

    if (*(p + 1) == '*') {
         return (isMatchHelper(s, p + 2) || (first_match && isMatchHelper(s + 1, p)));
    } else {
         return first_match && isMatchHelper(s + 1, p + 1);
    }
}

bool isMatch(const char* s, const char* p) {
    return isMatchHelper(s, p);
}
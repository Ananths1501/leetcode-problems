char* removeOccurrences(char* s, char* part) {
    int len_s = strlen(s);
    int len_part = strlen(part);
    
    int index = 0;

    for (int i = 0; i < len_s; i++) {
        s[index++] = s[i];

        if (index >= len_part && strncmp(&s[index - len_part], part, len_part) == 0) {
            index -= len_part;
        }
    }

    s[index] = '\0';

    return s;
}
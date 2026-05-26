class Solution {
    public void reverseWords(char[] s) {
        int start = 0, end = s.length-1;
        reverse(s, start, end);
        start = 0;
        end = 0;
        while (end < s.length) {
            while(end < s.length && s[end] != ' '){
                end++;
            }
            reverse(s, start, end-1);
            start = end+1;
            end+=1;
        }
        reverse(s, start, end-1);
    }

    public void reverse(char[] word, int start, int end){
        while (start < end) {
            char temp = word[start];
            word[start++] = word[end];
            word[end--] = temp;
        }
    }
}

/* 
the sky is blue

blue is sky the

eht yks si eulb
blue is sky the



*/
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int left = 0, right =0;
        int noOfChildren = g.length, maxCookies = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        while (left < maxCookies && right < noOfChildren) {
            if(g[right] <= s[left]){
                right++;
            }
            left++;
        }
        return right;
    }
}
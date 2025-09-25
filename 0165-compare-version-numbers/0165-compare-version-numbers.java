class Solution {
    public int compareVersion(String version1, String version2) {
        int ptr1 = 0, ptr2=0, version1Length = version1.length(), version2Length = version2.length() ;
        while (ptr1 < version1Length || ptr2 < version2Length) {
            int num1 =0, num2 =0;
            while (ptr1 < version1Length && version1.charAt(ptr1) != '.' ) {
                num1 = (num1 * 10) + version1.charAt(ptr1) - '0';
                ptr1++;
            }
            while (ptr2 < version2Length && version2.charAt(ptr2) != '.' ) {
                num2 = (num2 * 10 ) + version2.charAt(ptr2) - '0';
                ptr2++;
            }
            if (num1 < num2) return -1;
            else if(num1 > num2) return 1;
            ptr1++;
            ptr2++;
        }
        return 0;
    }
}
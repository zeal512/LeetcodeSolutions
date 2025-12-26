class Solution {
    public int minimumPushes(String word) {
        int size = word.length();
        int minPushes = 0, multiplier = 1;
        while (size > 0) {
            if(size - 8 <=0){
                minPushes += size * multiplier;
            }
            else{
                minPushes += 8 * multiplier;
            }
            multiplier+=1;
            size-=8;
        }
        return minPushes;
    }
}

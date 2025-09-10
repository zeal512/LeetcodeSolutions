class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int location1 = -1, location2 = -1, minDistance = Integer.MAX_VALUE;
        for(int i=0; i< wordsDict.length; i++){
            if(wordsDict[i].equals(word1))  {
                location1 = i;
            }
            else if(wordsDict[i].equals(word2)){
                location2 = i;
            }
            if (location1 != -1 && location2 != -1) {
                minDistance = Math.min(minDistance , Math.abs(location1 - location2));
            }
        }
        return minDistance;
    }
}
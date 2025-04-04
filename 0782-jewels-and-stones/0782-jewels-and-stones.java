class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> uniqueJewels = new HashSet<>();
        for (Character jewel : jewels.toCharArray()) {
            uniqueJewels.add(jewel);
        }
        int countStones =0;
        for (Character stone : stones.toCharArray()) {
            if(uniqueJewels.contains(stone)) countStones+=1;
        }
        return countStones;
    }
}
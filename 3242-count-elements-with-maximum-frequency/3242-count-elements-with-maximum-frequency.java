class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0, maxCount =0;
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0)+1);
            maxFrequency = Math.max(maxFrequency, frequencies.get(num));
        }
        for(int key : frequencies.keySet()){
            if (frequencies.get(key) == maxFrequency ) maxCount+=frequencies.get(key);
        }
        return maxCount;
    }
}
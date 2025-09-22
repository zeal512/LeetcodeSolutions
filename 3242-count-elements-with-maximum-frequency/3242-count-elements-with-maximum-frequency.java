class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        int maxFrequency = 0, maxCount =0;
        for (int num : nums) {
            int frequency = frequencies.getOrDefault(num, 0)+1;
            frequencies.put(num, frequency);
            if ( frequency > maxFrequency ) {
                maxFrequency = frequency;
                maxCount = frequency;
            }else if (frequency == maxFrequency ) maxCount+=frequency;
        }
        return maxCount;
    }
}
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = 0, max = 0;
        for (int weight : weights) {
            min = Math.max(min, weight);
            max += weight;
        }
        while (min < max) {
            int avgWeight = (min + max) / 2;
            System.out.println(avgWeight);
            if (isPossible(weights, avgWeight, days)) {
                max = avgWeight;
            } else {
                min = avgWeight + 1;
            }
        }
        return min;
    }

    public boolean isPossible(int[] weights, int currWeight, int days) {
        int sum = 0, totalDays = 1;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > currWeight) {
                totalDays += 1;
                sum = weights[i];
            }
        }
        return totalDays <= days;
    }
}
class Solution {
    public int totalFruit(int[] fruits) {
        int count = 0, left = 0;
        HashMap<Integer, Integer> fruitTypes = new HashMap<>();

        for(int right =0; right < fruits.length; right++){
            fruitTypes.put(fruits[right], fruitTypes.getOrDefault(fruits[right], 0)+1);
            while (fruitTypes.size() > 2) {
                fruitTypes.put(fruits[left], fruitTypes.getOrDefault(fruits[left], 0)-1);
                if (fruitTypes.get(fruits[left]) == 0) {
                    fruitTypes.remove(fruits[left]);
                }
                left++;
            }
            count = Math.max(count, right - left + 1);
        }
        return count;
    }
}
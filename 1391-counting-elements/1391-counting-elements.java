class Solution {
    public int countElements(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        int count =0;
        for (int num : arr) {
            unique.add(num);
        }
        for (int num : arr) {
            if (unique.contains(num+1)) count++;
        }
        return count;
    }
}
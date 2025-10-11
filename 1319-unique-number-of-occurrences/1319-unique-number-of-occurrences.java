class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        /* Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num,0) +1 );
        }
        Set<Integer> set = new HashSet<>();
        for (Integer num : map.values()) {
            if (set.contains(num)) return false;
            set.add(num);
        }
        return true; */
        int helper = 1000;
        int[] counter = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            counter[arr[i] + helper]++;
        }
        boolean[] encountered = new boolean[2001];
        for (int i = 0; i < counter.length; i++) {
            if(counter[i] == 0) continue;
            if(encountered[counter[i]]) return false;
            encountered[counter[i]] = true;
        }
        return true;
    }

}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) +1 );
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>
        (Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer,Integer> entry : map.entrySet() ){
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] arr = new int[k];
        int i = 0;
        
        while (!minHeap.isEmpty()) {
            arr[i++] = minHeap.poll().getKey();
        }
        return arr;
    }
}
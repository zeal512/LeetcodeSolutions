class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int num: nums){
            pqueue.add(num);
        }
        for (int i = 0; i < nums.length - k; i++) {
            pqueue.poll();
        }
        return pqueue.peek();
    }
}
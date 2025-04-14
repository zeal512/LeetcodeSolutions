class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();
        for(int num: nums){
            pqueue.add(num);
        }
        System.out.println(pqueue);
        int klargest = 0;
        for (int i = 0; i <= nums.length-k; i++) {
            klargest = pqueue.poll();
        }
        return klargest;
    }
}
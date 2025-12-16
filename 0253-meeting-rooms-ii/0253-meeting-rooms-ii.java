class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        int conferenceRooms = 0;
        for(int[] arr : intervals) {
            int start = arr[0];
            int end = arr[1];
            if(!pQueue.isEmpty() && start >= pQueue.peek()){
                pQueue.poll();
            }
            else{
                conferenceRooms+=1;
            }
            pQueue.offer(end);
        }
        return conferenceRooms;
    }
}
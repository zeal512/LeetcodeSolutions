class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[][] closest = new int[k][2];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] point : points){
            int distance = (point[0] * point[0]) + (point[1] * point[1]);
            queue.add(distance);
            map.putIfAbsent(distance, new ArrayList<>());
            map.get(distance).add(point);
        }
        int count = 0;
        while(count < k){
            int key = queue.poll();
            for(int[] point : map.get(key)){
                closest[count][0] = point[0];
                closest[count][1] = point[1];
                count++;
            }
        }
        return closest;
    }
}
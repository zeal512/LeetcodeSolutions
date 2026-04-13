class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /* PriorityQueue<Integer> queue = new PriorityQueue<>();
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
        return closest; */

        /* 
        In the above solution, instead of using a HashMap to store the distance as key an list as pair
        of points, we can simply store [<distance>, [index of points array]] and access the point from 
        points[].
        */
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[][] closest = new int[k][2];
        for(int i =0; i< points.length; i++){
            int distance = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            if(queue.size() < k){
                queue.add(new int[]{distance, i});
            }else if(queue.peek()[0] > distance ){
                queue.poll();
                queue.offer(new int[]{distance, i});
            }
        }
        for(int i =0; i< k; i++){
            int idx = queue.poll()[1];
            closest[i] = points[idx];
        }
        return closest;
    }
}
class Pair{
    int node, price;
     Pair(int node, int price){
        this.node = node;
        this.price = price;
     }    
}

class Tuple{
    int stops, node, cost;
     Tuple(int stops, int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
     }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++){
            int source = flights[i][0], dest = flights[i][1], price = flights[i][2];
            adj.get(source).add(new Pair(dest, price));
        }
        
        int costArr[] = new int[n];
        Arrays.fill(costArr, Integer.MAX_VALUE);
        
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(0,src, 0));
        costArr[src] = 0;
        while(!queue.isEmpty()){
            Tuple cur = queue.poll();
            int node = cur.node;
            int stopCt = cur.stops;
            int cost = cur.cost;
            
            if(stopCt > k) continue;
            for(Pair p: adj.get(node)){
                int nextStop = p.node;
                int price = p.price;

                if(cost + price < costArr[nextStop] && stopCt <= k){
                    costArr[nextStop] = cost + price;
                    queue.add(new Tuple(stopCt+1, nextStop, cost + price));
                }
            }

        }
        if(costArr[dst] == Integer.MAX_VALUE) return -1;
        return costArr[dst];
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];
        for(char ch : tasks){
            frequency[ch - 'A']+=1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for(int freq : frequency){
            if(freq > 0) queue.add(freq);
        }
        int intervals = 0;
        while(!queue.isEmpty()){
            List<Integer> updated = new ArrayList<>();
            int cycleLife = n+1;
            while(cycleLife > 0 && !queue.isEmpty()){
                int taskFreq = queue.poll();
                cycleLife-=1;
                intervals+=1;
                updated.add(taskFreq-1);
            }
            for(int freq : updated){
                if(freq > 0) queue.add(freq);
            }
            if(!queue.isEmpty()) intervals +=cycleLife;
        }
        return intervals;
    }
}
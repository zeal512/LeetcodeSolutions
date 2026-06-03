class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(startGene);
        int minimum_mutations = 0;
        while (!queue.isEmpty()) {
            int currSize = queue.size();

            for(int i =0; i < currSize; i++){
                String node = queue.poll();
                if(node.equals(endGene)){
                    return minimum_mutations;
                }
                
                for(char ch : new char[] {'A', 'C', 'G','T'}){
                    for(int k =0; k < node.length(); k++){
                        String neighbour = node.substring(0, k) + ch + node.substring(k+1);
                        if(!set.contains(neighbour) && Arrays.asList(bank).contains(neighbour) ){
                            queue.offer(neighbour);
                            set.add(neighbour);
                        }
                    }
                }
            }
            minimum_mutations+=1;
        }
        return -1;
    }
}
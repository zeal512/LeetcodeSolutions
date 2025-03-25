class SmallestInfiniteSet {

    int current =1;
    PriorityQueue<Integer> pqueue;
    Set<Integer> addSet;

    public SmallestInfiniteSet() {
        current =1;
        pqueue = new PriorityQueue<>();
        addSet = new HashSet<>();   
    }
    
    public int popSmallest() {
        if(!pqueue.isEmpty()){
            int smallestNum = pqueue.poll();
            addSet.remove(smallestNum);
            return smallestNum;
        }
        return current++;
    }
    
    public void addBack(int num) {
        if(num < current && !addSet.contains(num)){
            addSet.add(num);
            pqueue.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
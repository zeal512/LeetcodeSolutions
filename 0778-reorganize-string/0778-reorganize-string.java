class Pair {
    int num;
    char ch;
    Pair(int num, char ch){
        this.num = num;
        this.ch = ch;
    }
};
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for (char ch : s.toCharArray()) {
            int freq = map.getOrDefault(ch, 0)+1;
            map.put(ch, freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        if(maxFreq > (s.length() + 1)/2) return "";
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.num, a.num));
        for(char ch: map.keySet()){
            int freq = map.get(ch);
            pq.offer(new Pair(freq, ch));
        }
        StringBuilder sb = new StringBuilder();
        Pair prev = null;

        while (!pq.isEmpty()) {
            Pair currPair = pq.poll();
            char ch = currPair.ch;
            sb.append(ch);
            currPair.num-=1;
            if(prev != null && prev.num > 0) pq.offer(prev);
            prev = currPair;
            
        }
        return sb.toString();
    }
}
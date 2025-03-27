class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> count = new HashMap<>();
        String s = "balon";

        for(char ch: s.toCharArray()){
            count.put(ch, 0);
        }

        for(char ch: text.toCharArray()){
            if(count.containsKey(ch)){
                count.put(ch, count.get(ch) + 1);
            }
        }
        int b = count.get('b');
        int a = count.get('a');
        int l = count.get('l') / 2;
        int o = count.get('o') / 2;
        int n = count.get('n');

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}
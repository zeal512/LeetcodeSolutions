import java.util.Hashtable;
class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int left =0, right=numbers.length-1;

        Hashtable<Integer, Integer> table = new Hashtable<>();
        for(int i=0; i< numbers.length; i++){
            int val =target - numbers[i];
            if(table.containsKey(val)){
                int[] res = {table.get(val), i};
                return res;
            }
            table.put(numbers[i], i);
        }
        return new int[0];
    }
}

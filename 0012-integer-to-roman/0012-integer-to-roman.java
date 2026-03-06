class Solution {
    public String intToRoman(int num) {
        /* int[] integerVal = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]   {"M", "CM", "D", "CD", "C", "XC","L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer result = new StringBuffer();
        for(int i=0; i< integerVal.length && num > 0; i++){
            while (num >= integerVal[i]) {
                result.append(roman[i]);
                num-=integerVal[i];
            }
        }
        return result.toString(); */
        Map<Integer, String> dict = new LinkedHashMap<>();
        dict.put(1000,"M");
        dict.put(900,"CM");
        dict.put(500,"D");
        dict.put(400,"CD");
        dict.put(100,"C");
        dict.put(90,"XC");
        dict.put(50,"L");
        dict.put(40,"XL");
        dict.put(10,"X");
        dict.put(9,"IX");
        dict.put(5,"V");
        dict.put(4,"IV");
        dict.put(1,"I");
        int temp = num;
        StringBuffer buffer= new StringBuffer();
        for(int val : dict.keySet()){
            if(temp >= val){
                int q = temp / val;
                buffer.append(dict.get(val).repeat(q));
                temp -=(q * val);
            }
        }
        return buffer.toString();
    }
}

/* 
Time and space complexity will be O(1)

- Time complexity is O(1) because the range is finite, 1 to 3999. So there are finite number of iterations(the loop runs at max 6 times). 

- Space complexity is O(1) because we are storing only 13 values in integerVal and roman arrays, which are constant. 
*/
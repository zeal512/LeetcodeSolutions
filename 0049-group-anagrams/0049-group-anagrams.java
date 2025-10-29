class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> output = new ArrayList<>();
        for(String str : strs){
            char[] strToArray = str.toCharArray();
            Arrays.sort(strToArray);
            String sortedString = new String(strToArray);
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
                map.get(sortedString).add(str);
            }
            else map.get(sortedString).add(str);
        }
        for(String key :map.keySet()){
            output.add(map.get(key));
        }
        return output;
    }
}
class Pair{
    String code;
    int priority;
    Pair(int priority, String code){
        this.priority = priority;
        this.code = code;
    }
}
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        
        Map<String, Integer> businessLinePriority = new HashMap<>();
        businessLinePriority.put("electronics", 1);
        businessLinePriority.put("grocery", 2);
        businessLinePriority.put("pharmacy", 3);
        businessLinePriority.put("restaurant", 4);
        
        int n = isActive.length;
        List<Pair> validPairs = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(isActive[i] && businessLinePriority.containsKey(businessLine[i]) && isValid(code[i])){
                validPairs.add(new Pair(businessLinePriority.get(businessLine[i]), code[i]));
            }
        }
        Collections.sort(validPairs, (a,b) -> {
            if(a.priority != b.priority)
                return a.priority - b.priority;
            return a.code.compareTo(b.code);
        } );
        List<String> result = new ArrayList<>();
        for(Pair p : validPairs){
            result.add(p.code);
        }
        return result;
    }

    public static boolean isValid(String code){
        if(code.length() == 0) return false;
        for(char ch: code.toCharArray()){
            if(!Character.isLetterOrDigit(ch) && ch != '_') return false;
        }
        return true;
    }
}
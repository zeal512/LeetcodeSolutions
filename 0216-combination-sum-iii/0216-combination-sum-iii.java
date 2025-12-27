class Solution {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        int start = 1, end = 9;
        List<List<Integer>> result = new ArrayList<>();
        helper(start, end, k, n, 0, new ArrayList<>(), result);
        return result;
    }

    public static void helper(int start, int end, int maxNum, int maxSum, int currSum, List<Integer> currList, List<List<Integer>> result) {
        if (currSum == maxSum && currList.size() == maxNum) {
            result.add(new ArrayList<>(currList));
            return;
        }
        if(currSum > maxSum || currList.size() >= maxNum){
            return;
        }
        for (int num = start; num <= end; num++) {
            currList.add(num);
            helper(num +1, end, maxNum, maxSum, currSum + num, currList, result);
            currList.remove(currList.size()-1);
        }
    }
}